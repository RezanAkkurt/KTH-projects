/*C program to print size of variables using sizeof() operator.

A bit stores just a 0 or 1
One byte = grouping of 8 bits

In general: add 1 bit, double the number of patterns
1 bit - 2 patterns
2 bits - 4
3 bits - 8
4 bits - 16
5 bits - 32
6 bits - 64
7 bits - 128
8 bits - 256 - one byte
Mathematically: n bits yields 2n patterns (2 to the nth power)

One byte can hold a number between 0 and 255

BYTES AND CHARACTERS - ASCII CODE
ASCII is an encoding representing each typed character by a number
Each number is stored in one byte (so the number is in 0..255)
A is 65 (41 in hexadecimal - 0100 (=4) 0001 (=1))
B is 66
a is 96 (61 in hexadecimal - 0101 (=6) 0001 (=1))
m is 109 (6D in hexadecimal - 0101 (=6) 1101 (=D))
space is 32
"Unicode" is an encoding for mandarin, greek, arabic, etc. languages, typically 2-bytes per "character"

TYPE:              STORAGE SIZE      VALUE RANGE
char	           1 byte	         -128 to 127 or 0 to 255
unsigned char	   1 byte	         0 to 255
signed char	       1 byte	         -128 to 127
int	               2 or 4 bytes	     -32,768 to 32,767 or -2,147,483,648 to 2,147,483,647
unsigned int	   2 or 4 bytes	     0 to 65,535 or 0 to 4,294,967,295
short	           2 bytes	         -32,768 to 32,767
unsigned short	   2 bytes	         0 to 65,535
long	           4 bytes	         -2,147,483,648 to 2,147,483,647
unsigned long	   4 bytes           0 to 4,294,967,295

Type	           Storage size	     Value range	          Precision
float	           4 byte	         1.2E-38 to 3.4E+38	      6 decimal places
double	           8 byte	         2.3E-308 to 1.7E+308	  15 decimal places
long double	       10 byte	         3.4E-4932 to 1.1E+4932	  19 decimal places

*/

#include <stdio.h>

int main()
{
    char    a       ='A';
    int     b       =120;
    float   c       =123.0f;
    double  d       =1222.90;
    char    str[]   ="Hello"; //one byte for each char and one byte for \o to tell processor where the string ends?

    printf("\nSize of char: %d",sizeof(a));
    printf("\nSize of int: %d",sizeof(b));
    printf("\nSize of float: %d",sizeof(c));
    printf("\nSize of double: %d",sizeof(d));
    printf("\nSize of string: %d",sizeof(str));

    return 0;
}
