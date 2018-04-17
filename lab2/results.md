| X                                 | <?>           | <? extends T> | <? super T>   |
| ------                            | :-------------: | :-------------: | :--------: |
| public T m()                      | +             | +             | +         |
| public void m( T arg)             | -             | -             | +         |
| public Y<T>f()                    | +             | +             | +         |
| public void f(Y< T > arg)         | -             | -             | -         |
| public Y<? extends T > f()        | +             | +             | +         |
| public void f(Y<? extends T > arg) | -            | -             | +         |
| public Y<? super T > f()          | +             | +             | +         |
| public void f(Y<? super T > arg)  | -             | +             | -         |
