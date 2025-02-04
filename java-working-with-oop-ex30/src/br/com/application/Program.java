
package br.com.application;

import br.com.model.entities.Circle;
import br.com.model.entities.Rectangle;
import br.com.model.entities.Shape;
import br.com.model.enums.Color;

public class Program {
    
    public static void main(String[] args) {

		Shape s1 = new Circle(Color.BLACK, 2.0);
		Shape s2 = new Rectangle(Color.WHITE, 3.0, 4.0);
		
		System.out.println("Circle color: " + s1.getColor());
		System.out.println("Circle area: " + String.format("%.3f", s1.area()));
		System.out.println("Rectangle color: " + s2.getColor());
		System.out.println("Rectangle area: " + String.format("%.3f", s2.area()));
	}
}
