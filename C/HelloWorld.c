/* Hello World program */

#include<stdio.h> //include information about standard library


// Pointers

/*
int *p; // Creates pointer variable ("p") of type int, ie it can store memory adress to an int variable.
p = &var; // Stores the memory adress of variable "var" (var must be variable of type int)
*p = dereferences pointer p, ie access or assign value to the memory that pointer p points to
*/

// adder is a function that recieves pointer refrences/variables (ie they contain the memory adress of other parts of the memory (our "real" variables))
// "A pointer is a variable whose value is the address of another variable, i.e., direct address of the memory location."
// the first two pointer variables are constants so that they cant be changed.
void adder(const int *x, const int *y, int *z) {
  *z = *x + *y;
  printf("%d\n", *x ); // prints out "10"
}

// foo is a function that recieves an int variable and adds 10 to the variable by calling the adder function.
// The arguments that are sent to the function adder when adder is called are the memory adresses of the variable.
// foo returns the int a when done.
int foo(int a){
  const int k = 10;
  adder(&k, &a, &a);

  return a;
}

void square_reverse(const double *x, const double *y, const int len){
  double temp;
  for(int i = 0; i < len; i++){
    temp = x[i] * x[i];
    y[len - 1 - i] = temp;
  }
}

int main(void){ // define a function called main that received no argument values
    printf("Hello World \n"); //main calls library function printf to print this sequence of characters, \n represents the newline character

    int test = foo(7);
    printf("Test = %d\n",test);


    int test1 = 22;
    int *j;
    j = &test1;
    *j = 20;
    printf("%d\n", test1);

    double in[] = {11.0, 20.0, 100.0};
    double out[3];
    square_reverse(in, out, 3);
    for(int i = 0; i < 3; i++) {
      printf("%lf ", out[i]);
    }

}
