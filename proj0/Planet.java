public class Planet {
    static final double G = 6.67e-11;

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double xdiff = xxPos - p.xxPos;
        double ydiff = yyPos - p.yyPos;
        return Math.sqrt(xdiff * xdiff + ydiff * ydiff);
    }

    public double calcForceExertedBy(Planet p) {
        double r = calcDistance(p);
        return G * mass * p.mass / (r * r);
    }

    public double calcForceExertedByX(Planet p) {
        double f = calcForceExertedBy(p);
        double dx = p.xxPos - xxPos;
        double r = calcDistance(p);
        return f * dx / r;
    }

    public double calcForceExertedByY(Planet p) {
        double f = calcForceExertedBy(p);
        double dy = p.yyPos - yyPos;
        double r = calcDistance(p);
        return f * dy / r;
    }

    public double calcNetForceExertedByX(Planet[] ps) {
        double f = 0;
        for (Planet p : ps) {
            if (this.equals(p))
                continue;
            f += calcForceExertedByX(p);
        }
        return f;
    }

    public double calcNetForceExertedByY(Planet[] ps) {
        double f = 0;
        for (Planet p : ps) {
            if (this.equals(p))
                continue;
            f += calcForceExertedByY(p);
        }
        return f;
    }

    public void update(double dt, double fX, double fY) {
        double aX = fX / mass;
        double aY = fY / mass;
        double newXVel = xxVel + dt * aX;
        double newYVel = yyVel + dt * aY;
        double newXPos = xxPos + dt * newXVel;
        double newYPos = yyPos + dt * newYVel;

        xxPos = newXPos;
        yyPos = newYPos;
        xxVel = newXVel;
        yyVel = newYVel;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "./images/" + imgFileName);
    }
}