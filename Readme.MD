EN:

Drink Vending Machine

The aim of the program is to provide the logic needed to use a vending machine with drinks. It supports the storage of various types of drinks - each has its own price. It accepts only coins with value: 10, 20 and 50 euro cents and 1 and 2 euros. The change is spent with 10, 20 and 50 euro cents coins. The machine is able to contain a certain number of drinks (20 pieces of each type) and coins (50 pieces of each type). It is also possible to fill and empty both the storage space for drinks and storage space for coins. The coins thrown into the machine fill the overall coins pool - the change is also spent from this pool. The user puts a coin into the machine and chooses the drink number. The machine checks whether the inserted coins are in a nominal values that are operated by the device and if possible it returns the drink. If drink can’t be served, machine displays error message.

The implementation contains:
- Coin - a simple class with a coin model, it has an information about the nominal value, the number of coins in the machine and the maximum capacity
- Drink - an another simple class that has an information about the drink number, its price, quantity and capacity of the machine (in the context of a given drink)
- MachineInitializer - a class is used to initialize lists in which we store information about drinks and coins. The list of drinks is filled with sample data. The list with coins is initialized with coins of nominal values used by the machine.
- MoneyUtil - an utility class that provides methods for handling functions provided by the machine (e.g. getting back change to user)
- VendingMachine - contains the basic logic that manages the entire machine

All classes have the appropriate classes with tests. The exception are Coin and Drink, which are so simple that they do not require testing.

Maven was used as a building tool - with it's help you can run the project and tests.
The tests were created in JUnit4.

__

PL:

Drink Vending Machine

Program ma na celu zapewnienie logiki potrzebnej do używania automatu z napojami. Obsługuje przechowywanie różnych rodzajów napojów - każdy posiada własną cenę. Przyjmuje tylko monety o nominale: 10, 20 i 50 eurocentów oraz 1 i 2 euro. Reszta jest wydawana za pomocą monet 10, 20 i 50 eurocentów. Automat jest w stanie pomieścić określoną ilość napojów (20 sztuk każdego rodzaju) i monet (50 sztuk każdego rodzaju). Możliwe jest także uzupełnienie i opróżnienie zarówno przestrzeni przechowującej napoje jak i tej, w której znajdują się monety. Niezależnie od tego monety wrzucane do automatu uzupełniają ogólną pulę - z niej też wydawana jest reszta. Użytkownik wrzuca do automatu monety i wybiera numer napoju. Automat sprawdza, czy wrzucone monety są w nominałach obsługiwanych przez urządzenie i, jeżeli jest to możliwe, zwraca napój oraz wydaje resztę. W przeciwnym wyświetla informację o przybliżonym błędzie. 

Na implementację składają się:
- Coin - prosta klasa stanowiąca model monety, posiada informację o nominale, ilości monet w automacie oraz maksymalnej pojemności
- Drink - kolejna prosta klasa, posiada informację o numerze napoju, jego cenie, ilości i pojemności automatu (w kontekście danego napoju)
- MachineInitializer - klasa służy do inicjalizowania list, których przechowujemy informację o napojach i monetach. Lista z napojami wypełniana jest przykładowymi danymi. Lista z monetami inicjalizowana jest monetami o nominałach obsługiwanych przez automat.
- MoneyUtil - klasa pomocnicza, która udostępnia metody do obsługi funkcji dostarczanych przez automat (np. Wydawanie reszty)
- VendingMachine - zawiera podstawową logikę zarządzającą całym automatem

Wszystkie klasy posiadają odpowiednie klasy z testami. Wyjątkiem są Coin i Drink, które są na tyle prostymi klasami, że nie wymagają testowania. 

Jako narzędzia do budowania użyto Mavena i z jego pomocą można uruchomić projekt i testy.
Testy zostały stworzone w oparciu o JUnit4.