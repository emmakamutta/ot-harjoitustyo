# Arkkitehtuuri

## Pakkausrakenne

Ohjelman pakkausrakenne noudattaa seuraavaa

![pakkauskuva](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/pakkauskaavio.png)


Pakkaus [emmakamutta.domain](https://github.com/emmakamutta/ot-harjoitustyo/tree/master/kudontasovellus/src/main/java/emmakamutta/domain) sisältää ohjelman sovelluslogiikan ja pakkaus [emmakamutta.ui](https://github.com/emmakamutta/ot-harjoitustyo/tree/master/kudontasovellus/src/main/java/emmakamutta/ui) taas sisältää ohjelman javaFX:llä toteutetun graafisen käyttöliittymän koodin.

## Käyttöliittymä
Käyttöliittymä sisältää seuraavat näkymät 
* aloitusnäkymä
* kangaspuiden määrittelynäkymä
* kudontanäkymä

Jokainen näistä on oma Scene-olionsa, joka sijoitetaan vuorollaan sovelluksen stageen. Kunkin Scenen luomisesta vastaa oma metodinsa, jotka kaikki sijaitsevat luokassa [emmakamutta.ui.Ui](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/kudontasovellus/src/main/java/emmakamutta/ui/Ui.java).

Käyttöliittymä on pyritty eriyttämään sovelluslogiikasta. Se kutsuukin lähinnä sovelluslogiikan oliota [Loom](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/kudontasovellus/src/main/java/emmakamutta/domain/Loom.java) ja tämän metodeja sovelluslogiikan suorittamiseksi.

Käyttöliittymän kudontanäkymä pohjautuu pitkälti neljään erilaiseen ruudukkoon ja useisiin nappeihin. Kunkin ruudukon toiminnasta vastaa oma luokkansa. Ne löytyvät pakkauksesta emmakamutta.ui. Jokainen näistä luokista perii valmiin JavaFX luokan GridPane, sillä sen päälle oli hyvä rakentaa ruudukoitten erityisempiä toiminnallisuuksia. 

Tässä sovelluksessa tallentaminen on myös toteutettu osana käyttöliittymää, sillä tallentaminen on toteutettu vain png-kuvana käyttöliittymänäkymästä. Siitä siis vastaa luokan emmakamutta.ui.Ui metodi ***saveAsImage(Scene)*** Tallennus on toteutettu käyttämällä javafx.stage oliota FileChooser ja ulkoista [JavaFx Swing](https://mvnrepository.com/artifact/org.openjfx/javafx-swing) -kirjastoa, jonka avulla käyttöliittymäkuva voidaan muuntaa png-muotoon.

## Sovelluslogiikka

Sovelluslogiikka koostuu neljästä eri luokasta ja rajapinnasta [Grid](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/kudontasovellus/src/main/java/emmakamutta/domain/Grid.java). Eri luokat kuvaavatkangaspuita ja sen osia. Koska ohjelmassa kangaspuun osat on toteutettu sovelluslogiikankin osalta erilaisina ruudukkoina, perivätkin suurin osa luokista rajapinnan Grid, joka tarjoaa metodit ***getRow(int)*** ja ***getColumn(int)***. Lisäksi luokat [Fabric](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/kudontasovellus/src/main/java/emmakamutta/domain/Fabric.java) ja [Heddles](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/kudontasovellus/src/main/java/emmakamutta/domain/Heddles.java) perivät luokan [UniversalGrid](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/kudontasovellus/src/main/java/emmakamutta/domain/UniversalGrid.java), sillä ne ovat tämän yleisemmän ruudukon erikoistapauksia laajemmalla toiminnallisuudella. 

![luokkakaavio](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/luokkakaavio.png)

Luokka [Loom](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/kudontasovellus/src/main/java/emmakamutta/domain/Loom.java) hallinnoi pitkälti kangaspuiden toimintaa. Aivan kuten oikeissakin kangaspuissa itse puut sisältävät pienempiä osasia, jotka vaikuttavat niiden toimintaan. Siispä luokka Loom on sisältää oliomuuttujina muut sovelluslogiikan luokat. Loom myös vastaa kangaspuiden päätoiminnallisuudesta, eli kutomisesta, metodilla ***weave(int)***. Lisäksi Loom osaa myös purkaa kutomistaan metodilla ***undo()***. 

## Päätoiminnallisuutta
Seuraavat sekvenssikaaviot kuvaavat joitakin ohjelman päätoiminnallisuuksia.
### Polkusten sidonnan määrittely
Kun käyttäjä on klikkaillut polkusten sidonnan haluamakseen ja varmistaa sen painamalla "Lukitse sidonta" -nappia, tapahtuu seuraava.
![sekvenssi](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/polkusten_varmistussekvenssi.png)

Käyttöliittymän tapahtumakäsittelijä kutsuu luokan treadlesPane metodia ***setModifiable(false)***, joka lukitsee sidontaruudukon muutoksilta. Sen jälkeen se kutsuu saman luokan metodia ***convertToTreadles()*** (kuvassa toistaiseksi vielä kirjoitusvirhe) tämä metodi palauttaa uuden UniversalGrid-olion, joka vastaa visualisaatiota Grid muodossa. Tämä olio asetetaan sitten olion **loom** metodin ***setTreadles(Grid)*** sisälle, jolloin sovelluslogiikan luokan Loom olio loom siis asettaa tuon parametrin kangaspuiden polkusten sidonnaksi.
