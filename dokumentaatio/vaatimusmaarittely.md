# Vaatimusmäärittely

## Sovelluksen tarkoitus
Sovelluksen avulla käyttäjä voi suunnitella erilaisia kudontamalleja ja simuloida kudontaa kangaspuilla suunnitelemalla sidoksellaan. 
Malleja voi myös tallentaa ja aikaisempia malleja tarkastella, mahdollisesti levylle tai tietokantaan. Joitan perussidosten malleja voisi olla jo valmiiksi muistissa. 
Sovellus simuloi oletuksellisesti kangaspuita, joissa on neljä niisivartta ja neljät polkuset. 
Malleja suunnitellaan määrittelemällä ensin polkusten sidonta sitä kuvaavaan ruudukkoon. Lisäksi määritellään niisintä omaan ruudukkoonsa.
Sitten käyttäjä voi painaa polkusia kuvaavia nappeja haluamassaan järjestyksessä, jolloin annettuun ruudukkoon tulee mallikuva siitä, millaista pintaa kutoessa tulisi. 
Myös polkusten poljentajärjestys näytetään mallikuvan vieressä. Halutessaan polkusten ja niisivarsien määrää voi muuttaa.

## Käyttöliittymäluonnos
![Käyttisluonnos kuva](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/kayttisluonnos.png)

Tämän lisäksi käyttöjärjestelmässä voisi olla valikko, josta löytyy jo valmiiksi joitakin perussidosten malleja. 

## Käyttäjät
Sovelluksessa on vain yhdenlaisia, tavallisia käyttäjiä.

## Toiminnallisuus
- Käyttäjä voi luoda uuden mallin, johon liittyy myös seuraavat asiat (**Tehty**)
  - Käyttäjä määrittelee käytettävien polkusten ja niisivarsien määrän 
    - oletusarvona molemmille on 4 
  - Käyttäjä määrittelee polkusten sidonnan 
    - esitetään oletusarvoisesti 4x4 ruudukkona. 
    - Jos polkusten ja niisivarsien määrä on mukautettu, niin ruudukko on muotoa axb, missä a on niisivarsien lukumäärä ja b on polkusten lukumäärä
  - Käyttäjä määrittelee niisinnän 
    - esitetään oletusarvoisesti 4x20 ruudukkona
    - jos mukautettu, niin ax20, missä a jälleen niisivarsien määrä
    - niisinnässä yksi sarake kuvaa yhtä loimilankaa, siis jokaisessa sarakkeessa voi olla valittuna vain yksi rivi, muuten kangaspuut eivät toimi.
 
- Käyttäjä voi myös valita jonkin jo aiemmin luodun mallin
  - siis sidonta ja niisintä ovat jo määritelty
  
- Edellä mainittujen suunnitelujen jälkeen käyttäjä voi simuloida kutomista painamalla polkusia haluamassaan järjestyksessä (**tehty**)
  - Polkusta painamalla mallikuvaan tulee näkyville uusi rivi. Tämä vastaa kutomisessa yhtä kuteen heittoa.
    - Mallikuvan rivillä musta ruutu esittää sitä, että kankaan pinnassa näkyy kude, valkoinen ruutu taas esittää loimilankaa. 
  - Polkemisjärjestys tulee näkyviin mallikuvan viereen omaan ruudukkoonsa

- Käyttäjä voi lopuksi tallentaa juuri luoman mallinsa 

- Esimerkkikuva kudontamallista

   ![esimerkkikuva](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/esimerkki.png)
   
   Tässä siis suurin ruudukko on mallikuva kudontajäljestä, sen oikealla puolella on polkemisjärjestys, alapuolella vasemmanpuoleinen ruudukko on niisintä ja oikeanpuoleinen polkusten sidonta. Mallikuva on esitetty pienempänä ruudukkona, kuin sovellukseen on tarkoitus tulla.


## Jatkokehitysideoita
- Loimen ja kuteen värin voi muuttaa.
- Loimen ja kuteen värin voi muuttaa niin, että raidalliset loimet ovat mahdollisia ja on mahdollista kutoa raitoja. 
- Kokonaisia lisätoiminnallisuuksia kudonnan suunnittelun avuksi: 
  - Erilaisia laskureita, kuten esimerkiksi kuteen menekin laskuri, loimen menekin laskuri, kutistumislaskuri yms. 
  - Omille malleille voi antaa enemmän määreitä, kuten nimen, suunnitellun pituuden, leveyden ja tiheyden yms.
