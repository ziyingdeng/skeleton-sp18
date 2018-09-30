public class Planet{
	public static double G = 6.67e-11;
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	/** Constructor */
	public Planet(double xP,double yP,double xV,double yV,double m,String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet P){
		xxPos = P.xxPos;
		yyPos = P.yyPos;
		xxVel = P.xxVel;
		yyVel = P.yyVel;
		mass = P.mass;
		imgFileName = P.imgFileName;

	}

	/** Return the distance between this and p*/
	public double calcDistance(Planet p){
		double xx = (this.xxPos - p.xxPos)*(this.xxPos - p.xxPos);
		double yy = (this.yyPos - p.yyPos)*(this.yyPos - p.yyPos);
		double dist = Math.sqrt(xx + yy);
		return dist;
	}

	/** Return the force between this Planet and Planet p */
	public double calcForceExertedBy(Planet p){
		double force = (G * this.mass * p.mass) / (calcDistance(p) * calcDistance(p));
		return force;
	}

	/** Return Fx*/
	public double calcForceExertedByX(Planet p){
		double force = calcForceExertedBy(p);
		double dx = Math.abs(p.xxPos - this.xxPos);
		double dist = calcDistance(p);
		return (force * dx) / dist;
	}

	/** Return Fy */ 
	public double calcForceExertedByY(Planet p){
		double force = calcForceExertedBy(p);
		double dy = Math.abs(p.yyPos - this.yyPos);
		double dist = calcDistance(p);
		return (force * dy) / dist;
	}

	/** Retruns several Planets interact each otehr byX  right+left-*/ 
	public double calcNetForceExertedByX(Planet[] allPlanets){ 
		int planetNum = allPlanets.length;
		double netForceByX = 0;
		int times = 0;
		while(times < planetNum){
			if(this.equals(allPlanets[times])){
				times++;
				continue;
			}else{
				if(allPlanets[times].xxPos > this.xxPos){
					netForceByX += calcForceExertedByX(allPlanets[times]);
					times++;
				}else{
					netForceByX -= calcForceExertedByX(allPlanets[times]);
					times++;
				}
			}
		}
		return netForceByX;
	}

	/** Retruns several Planets interact each otehr byY top+down- */ 
	public double calcNetForceExertedByY(Planet[] allPlanets){ 
		int planetNum = allPlanets.length;
		double netForceByY = 0;
		int times = 0;
		while(times < planetNum){
			if(this.equals(allPlanets[times])){
				times++;
				continue;
			}else{
				if(allPlanets[times].yyPos > this.yyPos){
					netForceByY += calcForceExertedByY(allPlanets[times]);
					times++;
				}else{
					netForceByY -= calcForceExertedByY(allPlanets[times]);
					times++;
				}
			}
		}
		return netForceByY;
	}

	/** Change the Vel and Pos under the force.*/
	public void update(double times,double forceX,double forceY){
		double aNetX = forceX / mass;
		double aNetY = forceY / mass;
		xxVel = xxVel + aNetX * times;
		yyVel = yyVel + aNetY * times;
		xxPos = xxPos + xxVel * times;
		yyPos = yyPos + yyVel * times;
	}

	public void draw(){
		String filename = "images/"+imgFileName;
		StdDraw.picture(xxPos,yyPos,filename);
	}

}