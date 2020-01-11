import functools
import string
import collections
from collections import Counter, defaultdict

def increment(iterable):

    for x in range(10):
        iterable[x] = iterable[x] + 1
    return iterable


def iloczyn(ciag_liczb):

    return functools.reduce(lambda x, y: x*y, ciag_liczb)


def palindrom(text):

    text = str.lower(text)                                  # zmiana wszystkich liter na małe

    for char in text:                                       # iterowanie po znakach
        if not(char.isalpha()):                             # sprawdzanie czy jest literą
            text = text.replace(char, '')

    stringlength = len(text)                                # długość tekstu
    reversed_text = text[stringlength::-1]                  # odwracanie tekstu

    return text == reversed_text


def tokenize(text):

    text = str.lower(text)

    for x in text:                                       # iterowanie po znakach
        if x in string.punctuation:                      # sprawdzanie, czy znak jest znakiem interpunkcyjnym
            text = text.replace(x, '')

    return text.split()


def remove_stopwords(text):

    with open('pl.stopwords.txt', 'r', encoding = 'UTF-8') as input_file:             # pobieranie z pliku
        stop_words = input_file.read()

    lista_slow = tokenize(text)                                                        # moje zdanie zamienione na pojedyncze słowa

    slowa = []                                                                         # lista, do kotrej dopisujemy poprawne słowa

    for x in lista_slow:
        if len(x) >= 2 and not(x in tokenize(stop_words)):
            slowa.append(x)

    x = " "                                                                   # inaczej join nie działa
    return x.join(slowa)


def count_most_frequent():

    with open('trurl.txt', 'r', encoding = 'UTF-8') as input_file:             # pobieranie z pliku
        text = input_file.read()

    text = remove_stopwords(text)
    text = tokenize(text)
    text_count = collections.Counter(text).most_common(20)                     # zliczanie najczesciej wystepujacych
    return text_count


def przeszukiwanie(tab):

    for x in tab:
        for i in range(tab.index(x) + 1, len(tab)):                           # przeszukuje od tego elementu do końca
            if sorted(x) == sorted(tab[i]):                                   # sortuje literki w słowie
                print(x, tab[i])                                              # wypisuje parę


def zad7():

    with open('unixdict.txt', 'r', encoding = 'UTF-8') as input_file:         # pobieranie z pliku
        text = input_file.read()
        tab = text.split('\n')                                                # tablica wyrazów

        dwa = []                                                              # tablice na słowa o danej długości
        trzy = []
        cztery = []
        piec = []
        szesc = []
        siedem = []
        osiem = []
        dziewiec = []
        dziesiec = []
        jedenascie = []
        dwanascie = []
        trzynascie = []
        czternascie = []
        pietnascie = []


        for x in tab:
            if len(x) == 2:
                dwa.append(x)
            if len(x) == 3:
                trzy.append(x)
            if len(x) == 4:
                cztery.append(x)
            if len(x) == 5:
                piec.append(x)
            if len(x) == 6:
                szesc.append(x)
            if len(x) == 7:
                siedem.append(x)
            if len(x) == 8:
                osiem.append(x)
            if len(x) == 9:
                dziewiec.append(x)
            if len(x) == 10:
                dziesiec.append(x)
            if len(x) == 11:
                jedenascie.append(x)
            if len(x) == 12:
                dwanascie.append(x)
            if len(x) == 13:
                trzynascie.append(x)
            if len(x) == 14:
                czternascie.append(x)
            if len(x) == 15:
                pietnascie.append(x)


        #przeszukiwanie(dwa)
        #przeszukiwanie(trzy)
        #przeszukiwanie(cztery)
        #przeszukiwanie(piec)
        #przeszukiwanie(szesc)
        #przeszukiwanie(siedem)
        #przeszukiwanie(osiem)
        #przeszukiwanie(dziewiec)
        #przeszukiwanie(dziesiec)
        #przeszukiwanie(jedenascie)
        przeszukiwanie(dwanascie)
        #przeszukiwanie(trzynascie)
        #przeszukiwanie(czternascie)
        #przeszukiwanie(pietnascie)






def main():

    #zad 1
    tab = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    print("\n" + f"Tablica: {tab}")
    print(f"Zwiększone o 1: {increment(tab)} \n")

    #zad2
    tab2 = [1, 2, 3, 4]
    print(f"Tablica: {tab2}")
    print(f"Iloczyn: {iloczyn(tab2)} \n")

    #zad3
    text = "Kajak"
    print(f"Palindrom: {palindrom(text)} \n")

    #zad4
    text2 = "To be, or not to be - that is the question [...]"
    print(f"Lista kolejnych słów: {tokenize(text2)} \n")

    #zad5
    text3 = "Male kotki sa cudowne i puchate, aczkolwiek groźne"
    print(f"Zdanie: {text3}")
    print(f"Zdanie po usunięciu: {remove_stopwords(text3)} \n")

    #zad6
    print(f"Najczęściej występujące: {count_most_frequent()} \n")

    #zad7
    print("Anagramy: ")
    zad7()


main();