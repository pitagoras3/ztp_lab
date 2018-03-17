# ztp_lab
Repository holding projects made for Advanced Programming Techniques course on Wrocław University of Science and Technology.

## SimpleMVC
Program oparty o architekturę MVC napisany w Javie, z wykorzystaniem repozytorium Mavena. Widokiem aplikacji jest konsola, więc w programie zastosowałem ViewControllery, zamiast rozbicia na poszczególne warstwy. Głównym problemem zadania było przełączanie się pomiędzy różnymi źródłami danych w czasie działania aplikacji - problem ten został rozwiązany z wykorzystaniem Dependency Injection i wzorca dostępu do danych DAO. Program potrafi współpracować z 2 źródłami danych - plikiem JSON oraz bazą danych opartą na MySQL. Do operacji CRUD na pliku JSON wykorzystałem bibliotekę Gson.

## Polymorphizm
