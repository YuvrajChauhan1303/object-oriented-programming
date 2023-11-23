#include <iostream>
#include <string>

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

class rectangle : public shape
{
private:
    double length;
    double breadth;

public:
    rectangle(double length, double breadth, std::string color)
    {
        this->length = length;
        this->breadth = breadth;
        this->color = color;
    }
    double getArea()
    {
        return this->breadth * this->length;
    }

    double getArea(double length)
    {
        this->length = length;
        this->breadth = length;
        return length * length;
    }

    double getArea(double length, double breadth)
    {
        this->length = length;
        this->breadth = breadth;

        return length * breadth;
    }
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

    circle * circle1 = new circle(radius, color);

    std::cout << "When NO parameter is Passed: " << circle1->getArea() << std::endl;
    std::cout << "When 1 Parameter is Passed ( circle1->getArea(10) ): " << circle1->getArea(10) << std::endl;

    return 0;
}