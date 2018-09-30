public class NBody{
	public static double readRadius(String fileName){
		In in = new In(fileName);
		int num = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String fileName){
		In in = new In(fileName);
		int num = in.readInt();
		double radius = in.readDouble();
		Planet [] p = new Planet[num];
		for(int i=0;i<num;i++){
			double xxPos = in.readDouble();
	 		double yyPos = in.readDouble();
	 		double xxVel = in.readDouble();
	 		double yyVel = in.readDouble();
	 		double mass = in.readDouble();
	 		String imgFileName = in.readString();
	 		p[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
		}
		return p;
		
	}

	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet [] p = readPlanets(filename);

		/** Draw the planets */
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0,0,"images/starfield.jpg");
		for(int i=0;i<p.length;i++){
			p[i].draw();
		}

		/** Make it move*/
		StdDraw.enableDoubleBuffering();
		double times = 0;
		while(times < T){
			double [] xForces = new double [p.length];
			double [] yForces = new double [p.length];
			for(int i = 0;i<p.length;i++){
				xForces[i] = p[i].calcNetForceExertedByX(p);
				yForces[i] = p[i].calcNetForceExertedByY(p);
			}
			StdDraw.clear();
			StdDraw.picture(0,0,"images/starfield.jpg");
			for(int i=0;i<p.length;i++){
				p[i].update(times,xForces[i],yForces[i]);
				p[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(100);
			times += dt;
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
            planets[i].yyVel, planets[i].mass, planets[i].imgFileName); 
    	}
	}
}