#include <iostream>
#include <string>
using namespace std;

/*
    Keywords Used:
    1. this
*/

class employee
{
private:
    int employeeID;
    string employeeName;
    string employeeDept;

public:
    employee(int employeeID,
             string employeeName,
             string employeeDept);

    employee(int employeeID,
             string employeeName);

    void display();
};

/*
    To reduce ambiquity, we would avoid default arguments to set employeeDept to general and instead set it in function.
*/
employee::employee(int employeeID, string employeeName, string employeeDept)
{
    this->employeeID = employeeID;
    this->employeeName = employeeName;
    this->employeeDept = employeeDept;
}

employee::employee(int employeeID, string employeeName)
{
    this->employeeID = employeeID;
    this->employeeName = employeeName;
    this->employeeDept = "General";
}

/*
    using Default arguments:

employee::employee(int employeeID, string employeeName, string employeeDept = "General")
{
    this->employeeID = employeeID;
    this->employeeName = employeeName;
    this->employeeDept = employeeDept;
}

*/

void employee::display()
{
    cout << endl;

    cout << "Employee ID: " << this->employeeID << endl;
    cout << "Employee Name: " << this->employeeName << endl;
    cout << "Employee Department: " << this->employeeDept << endl;

    cout << endl;
}

int main()
{
    // Create an array of objects:

    employee *empArray[2];

    empArray[0] = new employee(1024, "Employee 1", "Marketing");
    empArray[1] = new employee(2048, "Employee 2");

    empArray[0]->display();
    empArray[1]->display();

    return 0;
}