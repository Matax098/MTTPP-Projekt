### **Selenium WebDriver Automatizirano Testiranje**

Ovaj projekt implementira automatizirano testiranje web stranice koristeći Selenium WebDriver i Java u kombinaciji s TestNG testnim okvirom.  
Testovi provjeravaju osnovne funkcionalnosti web stranice kao što su pretraga proizvoda, dodavanje i uklanjanje proizvoda iz košarice te navigacija na početnu stranicu.  

---

## **Tehnologije korištene u projektu**
- **Java** – glavni programski jezik
- **Selenium WebDriver** – za web testiranje
- **TestNG** – testni okvir za organizaciju testova
- **ChromeDriver** – za pokretanje testova u Google Chrome pregledniku

---

## **Postavljanje i pokretanje testa**
### **Instalacija potrebnih alata**
- Instaliranje **JDK** (Java Development Kit) i postavljanje varijable okoline
- Instaliranje **Maven**
- Preuzimanje **ChromeDriver** i postavljanje u **C:\\drivers\\chromedriver.exe**
- Instaliranje **TestNG** ako koristiš Eclipse ili IntelliJ IDEA

## Testovi u projektu

### 1. Test pretrage na Google-u
- **Naziv testa:** `googleSearchTest()`
- **Opis:** Ovaj test provjerava može li se izvršiti pretraga na Google-u i kliknuti na prvi rezultat.
- **Koraci testa:**
  - Otvara Google početnu stranicu
  - Unosi pretragu za "thomann"
  - Klikne na prvi rezultat u rezultatima pretrage
  - Provjerava je li korisnik preusmjeren na službenu stranicu Thomanna

---

### 2. Test pretrage proizvoda
- **Naziv testa:** `testProductSearch()`
- **Opis:** Ovaj test provjerava funkcionira li pretraga proizvoda na web trgovini.
- **Koraci testa:**
  - Pretražuje proizvod "Gibson Les Paul"
  - Klikne na prvi rezultat pretrage
  - Provjerava je li naslov proizvoda ispravan

---

### 3. Test dodavanja proizvoda u košaricu
- **Naziv testa:** `testAddToCart()`
- **Opis:** Ovaj test provjerava može li se proizvod ispravno dodati u košaricu.
- **Koraci testa:**
  - Pretražuje proizvod "Gibson Les Paul"
  - Klikne na prvi proizvod u rezultatima
  - Klikne na gumb "Add to Cart"
  - Provjerava je li proizvod dodan u košaricu

---

### 4. Test uklanjanja proizvoda iz košarice
- **Naziv testa:** `testRemoveFromCart()`
- **Opis:** Ovaj test provjerava može li se proizvod ispravno ukloniti iz košarice.
- **Koraci testa:**
  - Otvara stranicu košarice
  - Klikne na gumb "Remove" pored proizvoda
  - Provjerava prikazuje li se poruka "Your shopping basket is empty at the moment."

---

### 5. Test vraća li gumb korisnika na početnu stranicu
- **Naziv testa:** `testHomeButtonRedirect()`
- **Opis:** Ovaj test provjerava radi li navigacija natrag na početnu stranicu putem glavnog gumba.
- **Koraci testa:**
  - Klikne na Thomann logo/gumb za povratak
  - Provjerava je li korisnik vraćen na početnu stranicu putem URL-a

---

- Svi testovi koriste Selenium WebDriver i TestNG.
- Korišteni su XPath-ovi za precizno pronalaženje elemenata.
- Testovi su automatizirani i pokreću se na Google Chrome pregledniku.
