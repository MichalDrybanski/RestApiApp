4SystemProject - Zadanie rekrutacyjne

Celem projektu jest wygenerowanie 50_000 pozycji pliku JSON. Plik ten powinien zostać
wgrany oraz wyświetlony na osobnym ekranie. Przy kolejnej próbie wgrania pliku o takim samym loginie, system powiadomi 
nas o błędzie dupliaktów. Ekran wyświetlania umożliwia sortowanie po imieniu, nazwisku i loginie, gdy zostanie naciśnięte 
odpowiednie pole w zależności od tego w jaki sposób chcemy uporządkować dane. Ponowne naciśnięcie tego samego pola
pozwala na zmianę kierunku sortowania.

Technologie:
Frontend: React
Backend: Spring
Baza danych: MySql
IDE: Visual Studio Code, IntelliJ IDEA

Instalacja
1. MySql
- w workbench MySQL dodajmy nowe połącznie
- podajemy odpowiednie dane znajdują się w pliku application.properties
- dokładna ściezka do pliku 4systemProject\4system\src\main\resources\application.properties
- uruchomić połącznie z serwerem
- 
3. Backend
- należy przejść do folderu 4system
- zainstalować zależności maven poleceniem mvn install
- w IDE otworzyc projekt 4system
- uruchomić aplikację

3. Frontend
- w VSC nalezy przejsc do folderu frontend
- w konsoli wpisać komendę npm install
- jeśli mamy uruchomiany backend, należy wpisać komendę npm start
- strone główną znajdziemy na procie localhost:3000/
