# Vaatimusmäärittely

## Sovelluksen tarkoitus
Sovelluksen avulla käyttäjä voi suunnitella erilaisia kudontamalleja ja simuloida kudontaa kangaspuilla suunnitelemalla sidoksellaan. 
Mallin voi sitten tallentaa kuvana omalle tietokoneelle.
Sovellus simuloi kangaspuita, joiden polkusten ja niisivarsien määrät käyttäjä voi itse valita. 
Malleja suunnitellaan määrittelemällä ensin polkusten sidonta omaan ruudukkoonsa ja niisintä omaan ruudukkoonsa.
Sitten käyttäjä voi painaa polkusia kuvaavia nappeja haluamassaan järjestyksessä, jolloin annettuun ruudukkoon tulee mallikuva siitä, millaista pintaa kutoessa tulisi. 
Myös polkusten poljentajärjestys näytetään mallikuvan vieressä. Tallennettua kuvaa voi sitten käyttää ohjeena sidoksen tekemiseksi oikeita kangaspuita laitettaessa kudontavalmiiksi.

## Kangaspuiden toiminnasta
Tämä sovellus pyrkii kuvaamaan todellisten kangaspuiden toimintaa. Tässä on kirjoittamani yksinkertainen [selitys](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/kangaspuiden_toiminnasta.md) aiheesta ja sovelluksen muodostaman mallikuvan lukemisesta.


## Käyttöliittymäluonnos
![Käyttisluonnos kuva](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/kayttisluonnos.png)

Tämän lisäksi käyttöjärjestelmässä on erilaisia nappeja, joilla voi esimerkiksi purkaa viimeisimmän rivin tai tyhjentää kaikki, sekä omat napit uuden mallin luomiseen ja nykyisen tallentamiseen.

## Käyttäjät
Sovelluksessa on vain yhdenlaisia, tavallisia käyttäjiä. Oletan kuitenkin, että pääasiallinen käyttäjäkunta olisi sovelluksen kohdeyleisöä ja siten perehtynyt kutomiseen ja kudontamallien lukemiseen. (Kts. kohta *Kangaspuiden toiminnasta*.)

## Toiminnallisuus
### Uuden mallin luominen
-  Käyttäjä voi määritellä käyttämänsä kangaspuut mallin luomisessa: 
   - Käyttäjä määrittelee käytettävien polkusten määrän 
   - Käyttäjä määrittelee käytettävien niisivarsien määrän
   - Käyttäjä määrittelee mallin suunnittelussa näkyvän kankaan leveyden ruutuina (yksi ruutu vastaa yhtä loimilankaa).
  
- Käyttäjä voi suunnitella erilaisia kudottuja sidoksia määrittelemillään kangaspuilla:
  - Käyttäjä määrittelee polkusten sidonnan
  - Käyttäjä määrittelee niisinnän
  
### Kudonnan simulointi
- Käyttäjä voi sitten kokeilla kutomista suunnittelemallaan sidoksella painamalla polkusia haluamassaan järjestyksessä.
  - Polkusta painamalla mallikuvaan tulee näkyville uusi rivi. Tämä vastaa kutomisessa yhtä kuteen heittoa. Mallikuvassa musta ruutu merkitsee sitä, että kude jää päälle, valkoinen ruutu taas esittää loimilankaa.
  - Polkemisjärjestys tulee näkyviin mallikuvan viereen omaan ruudukkoonsa
  
### Mallin tallentaminen
- Käyttäjä voi lopuksi tallentaa juuri luoman mallinsa haluamaansa hakemistoon omalla tietokoneellaan png-kuvana.

- Esimerkkikuva kudontamallista

   ![esimerkkikuva](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/esimerkki.png)
   
   Tässä siis suurin ruudukko on mallikuva kudontajäljestä, sen oikealla puolella on polkemisjärjestys, alapuolella vasemmanpuoleinen ruudukko on niisintä ja oikeanpuoleinen polkusten sidonta.


## Jatkokehitysideoita
- Mallin voi tallentaa halutessaan myös muussa muodossa, esim .jpg
- Mallit tallennettaisiin sellaisessa muodossa, että niitä voi muokata jälkeenpäinkin.
- Mallit tallennettaisiin tietokantaan, josta niitä olisi helppo tarkastella ja muokata.
- Loimen ja kuteen värin voi muuttaa.
- Loimen ja kuteen värin voi muuttaa niin, että raidalliset loimet ovat mahdollisia ja on mahdollista kutoa raitoja. 
- Kokonaisia lisätoiminnallisuuksia kudonnan suunnittelun avuksi: 
  - Erilaisia laskureita, kuten esimerkiksi kuteen menekin laskuri, loimen menekin laskuri, kutistumislaskuri yms. 
  - Omille malleille voi antaa enemmän määreitä, kuten nimen, suunnitellun pituuden, leveyden ja tiheyden yms.
