
public class Complex {

	double real, img;

	public Complex(double r, double i) {
		// TODO Auto-generated constructor stub
		this.real = r;
		this.img = i;
	}

	public Complex addition(Complex z, Complex c) {
		double real = z.real + c.real;
		double img = c.img + z.img;

		return new Complex(real, img);

	}	

	public double getMag(Complex z) {
		return Math.hypot(z.real, z.img);
	}

	public Complex square(Complex z) {
		double real = z.real * z.real - z.img * z.img;
		double img = 2 * z.img * z.img;

		return new Complex(real, img);

	}

	public boolean isMandelBrot(Complex z, int layers) {

		if (layers == 0) {
			return true;
		}
		if (getMag(z) > 2) {
			return false;
		} else {
			// z (new) = z^2 + c
			z = square(z);
			z = addition(z, this);
			layers--;
			return isMandelBrot(z, layers);
		}

	}
}
