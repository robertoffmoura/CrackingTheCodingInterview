/*
Find the mistake in the following code
*/

unsigned int i;
for (int i = 100; i >= 0; --i)
    printf("%d\n", i)

/*
Since i is unsigned, it will never be smaller than zero so the loop will never break. Also %d should be %u.
*/
