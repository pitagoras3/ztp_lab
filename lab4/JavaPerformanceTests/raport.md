# Raport badania wydajnosci

## Opis środowiska testowego

Testy badania wydajności uruchamiane były w IDE IntelliJ na komputerze z procesorem Intel Core i5, 16GB RAM.

Wersja Javy: 9.0.4

Tablice sortowane były z wykorzystaniem statycznej metody klasy _Array_

```Java
Arrays.sort(array);
```

Jednak _niezalezne od tablicy_ sortowanie Arraylisty osiągnąłem poprzez wykorzystanie __strumieni__ w Javie 8.

```Java
list.stream().sorted().collect(Collectors.toCollection(ArrayList::new));
```

## Uzyskane wyniki czasowe

Ponizsze wyniki czasowe uzyskane są w _nanosekundach_.

|           | 1000          | 10 000            | 100 000       |
|-----------| ------------: |-------------:     | -----:        |
|Array      |   83471       | 888391            | 9971145       |
|ArrayList  |   359399      | 2672911           | 36849428      |

## Wnioski

Dosyć jasno mozna zobaczyc, ze operacje na tablicy są wykonywane szybciej niz operacje na ArrayList. Jednakze, łatwość korzystania z ArrayList w trakcie programowania powoduje, ze w przypadkach kiedy nie musimy mocno optymalizowac kodu - są o wiele wygodniejszym rozwiązaniem.

Trzeba mieć jednak na uwadze fakt, iż wyniki pomiędzy ArrayListą a tablicą mogą się różnić ze względu na niezastosowanie tego samego algorytmu sortującego. Dlatego w bieżącej chwili wyników nie można uznać za w pełni rzetelnych.
