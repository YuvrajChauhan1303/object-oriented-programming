#include <iostream>
#include <string>

/* Create a Class shape */

class shape
{
protected:
    std::string color;

public:
    double getArea(double radius)
    {
        std::cout << "This is getArea() in Shape class" << std::endl;
        return 3.14 * radius * radius;
    }
    double getArea(double length, double breadth)
    {
        std::cout << "This is getArea() in Shape class" << std::endl;
        return length * breadth;
    }
};

/* Inherited the Class circle from base Class shape */
class circle : public shape
{
private:
    double radius;

public:
    circle(double radius, std::string color)
    {
        this->color = color;
        this->radius = radius;
    }
    //Operator Overloading in circle class.
    double getArea()
    {
        return 3.14 * this->radius * this->radius;
    }
    double getArea(double radius)
    {
        this->radius = radius;
        return 3.14 * radius * radius;
    }
};

/* Inherited the Class rectangle from base Class shape */

class rectangle : public shape
{
private:
    double length;
    double breadth;

public:
    // Constructor
    rectangle(double length, double breadth, std::string color)
    {
        this->length = length;
        this->breadth = breadth;
        this->color = color;
    }
    /*
        We Need to show Operator Overloading in this.
        I have used 3 different methods, with the same name, but variable-length parameters.
        It is also showing operator Overriding as getArea() method is also declaread and defined in the base class -> shape.
    */

    double getArea()
    {
        return this->breadth * this->length;
    }
    /*
        This getArea() method will simply use "this" pointer to access values and return the area.
    */
    double getArea(double length)
    {
        this->length = length;
        this->breadth = length;
        return length * length;
    }
    /*
        This getArea() method will take the "length" as an input and change the values of both length and breadth, thus creating a shape.
     */
    double getArea(double length, double breadth)
    {
        this->length = length;
        this->breadth = breadth;

        return length * breadth;
    }
    /*
       This getArea() method will take both length and breadth as inputs, and change the respective values and provide the area.
   */
};

int main()
{
    double l, b;
    std::string color;

    std::cout << "Enter Length: ";
    std::cin >> l;
    std::cout << "Enter Breadth: ";
    std::cin >> b;
    std::cout << "Enter Color: ";
    std::cin >> color;

    rectangle *r1 = new rectangle(l, b, color);

    std::cout << "When NO parameter is Passed: " << r1->getArea() << std::endl;
    std::cout << "When 1 Parameter is Passed ( r1->getArea(10) ): " << r1->getArea(10) << std::endl;
    std::cout << "When 2 Parameters are Passed ( r1->getArea(10, 20) ) : " << r1->getArea(10, 20) << std::endl;

    std::cout << std::endl;
    std::cout << std::endl;

    double radius;

    std::cout << "Enter Radius: ";
    std::cin >> radius;
    std::cout << "Enter Color: ";
    std::cin >> color;

    circle *circle1 = new circle(radius, color);

    std::cout << "When NO parameter is Passed: " << circle1->getArea() << std::endl;
    std::cout << "When 1 Parameter is Passed ( circle1->getArea(10) ): " << circle1->getArea(10) << std::endl;

    return 0;
}