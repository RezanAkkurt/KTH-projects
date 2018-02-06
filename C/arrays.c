/*
An array is an array and a pointer is a pointer, but in most cases array names
are converted to pointers. A term often used is that they decay to pointers.

Here is an array:

int a[7];
// a contains space for seven integers, and you can put a value in one of them with
// an assignment, like this:

a[3] = 9;

Here is a pointer:
int *p;
// p doesn't contain any spaces for integers, but it can point to a space for an
// integer. We can, for example, set it to point to one of the places in the array
// a, such as the first one:

p = &a[0];

What can be confusing is that you can also write this:
p = a;
This does not copy the contents of the array a into the pointer p (whatever that
would mean). Instead, the array name a is converted to a pointer to its first element.
So that assignment does the same as the previous one.

Now you can use p in a similar way to an array:

p[3] = 17;
The reason that this works is that the array dereferencing operator in C, "[ ]",
is defined in terms of pointers. x[y] means: start with the pointer x, step y elements
forward after what the pointer points to, and then take whatever is there. Using pointer
arithmetic syntax, x[y] can also be written as *(x+y).

For this to work with a normal array, such as our a, the name a in a[3] must first
be converted to a pointer (to the first element in a). Then we step 3 elements forward,
and take whatever is there. In other words: take the element at position 3 in the array.
(Which is the fourth element in the array, since the first one is numbered 0.)

So, in summary, array names in a C program are (in most cases) converted to pointers.
One exception is when we use the sizeof operator on an array. If a was converted to a
pointer in this context, sizeof(a) would give the size of a pointer and not of the actual
array, which would be rather useless, so in that case a means the array itself.

*/

/*
An array name itself is the adress of the first element of that array. For example if
array name is "test" then you can say that test is equivalent to the &test[0]

When an array is used as a value, its name represents the address of the first element.
When an array is not used as a value its name represents the whole array.

int arr[7];

// arr used as value
foo(arr);
int x = *(arr + 1); // same as arr[1]

// arr not used as value
size_t bytes = sizeof arr;
void *q = &arr; // void pointers are compatible with pointers to any object

*/
#include <stdio.h>

void square_reverse(double *x, double *y, const int len);

int main(void){

    double in[] = {11.0, 20.0, 100.0, 10};
    double out[4];
    square_reverse(in, out, 4); // går också att skicka array som &in[0];
    for(int i = 0; i < 4; i++) {
      printf("%lf \n", out[i]);
    }

}

void square_reverse(double *x, double *y, const int len){
  for(int i = 0; i < len; i++){
    printf("%lf \n", x[i]);
    x[i] = x[i] * x[i];
    y[len - 1 - i] = x[i];
  }
}
