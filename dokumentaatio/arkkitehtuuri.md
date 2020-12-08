# Arkkitehtuuri

## Pakkausrakenne

Ohjelman pakkausrakenne noudattaa seuraavaa, joskin pakkaus dao puuttuu vielä kokonaan.

![pakkauskuva](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/pakkauskaavio.png)


Pakkaus emmakamutta.domain sisältää ohjelman sovelluslogiikan ja pakkaus emmakamutta.ui taas sisältää ohjelman javaFX:llä toteutetun graafisen käyttöliittymän koodin.

## Käyttöliittymä
Käyttöliittymä sisältää seuraavat näkymät 
* aloitusnäkymä
* kangaspuiden määrittelynäkymä
* kudontanäkymä

Jokainen näistä on oma Scene-olionsa, joka sijoitetaan vuorollaan sovelluksen stageen. Kunkin Scenen luomisesta vastaa oma metodinsa, jotka kaikki sijaitsevat luokassa emmakamutta.ui.Ui.

Käyttöliittymä on pyritty eriyttämään sovelluslogiikasta. Se kutsuukin lähinnä sovelluslogiikan oliota Loom ja tämän metodeja sovelluslogiikan suorittamiseksi.

Käyttöliittymän kudontanäkymä pohjautuu pitkälti neljään erilaiseen ruudukkoon ja useisiin nappeihin. Kunkin ruudukon toiminnasta vastaa oma luokkansa. Ne löytyvät pakkauksesta emmakamutta.ui.

## Sovelluslogiikka

Sovelluslogiikka koostuu neljästä eri luokasta ja rajapinnasta Grid. Eri luokat kuvaavatkangaspuita ja sen osia. Koska ohjelmassa kangaspuun osat on toteutettu sovelluslogiikankin osalta erilaisina ruudukkoina, perivätkin suurin osa luokista rajapinnan Grid, joka tarjoaa metodit ***getRow(int)*** ja ***getColumn(int)***. Lisäksi luokat Fabric ja Heddles perivät luokan UniversalGrid, sillä ne ovat tämän yleisemmän ruudukon erikoistapauksia laajemmalla toiminnallisuudella. 

![luokkakaavio](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/luokkakaavio.png)

Luokka Loom hallinnoi pitkälti kangaspuiden toimintaa, aivan kuten oikeissakin kangaspuissa itse puut sisältävät pienempiä osasia, jotka vaikuttavat niiden toimintaan. Siispä luokka Loom on sisältää muuttujina muut sovelluslogiikan luokat. Loom myös vastaa kangaspuiden päätoiminnallisuudesta, eli kutomisesta, metodilla ***weave(int)***. Lisäksi Loom osaa myös purkaa kutomistaan metodilla ***undo()***. 

## Päätoiminnallisuutta
Seuraavat sekvenssikaaviot kuvaavat joitakin ohjelman päätoiminnallisuuksia.
### Polkusten sidonnan määrittely
Kun käyttäjä on klikkaillut polkusten sidonnan haluamakseen ja varmistaa sen painamalla "Lukitse sidonta" -nappia, tapahtuu seuraava.
![sekvenssi](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/polkusten_varmistussekvenssi.png)

Käyttöliittymän tapahtumakäsittelijä kutsuu luokan treadlesPane metodia ***setModifiable(false)***, joka lukitsee sidontaruudukon muutoksilta. Sen jälkeen se kutsuu saman luokan metodia ***convertToTreadles()*** (kuvassa toistaiseksi vielä kirjoitusvirhe) tämä metodi palauttaa uuden UniversalGrid-olion, joka vastaa visualisaatiota Grid muodossa. Tämä olio asetetaan sitten olion **loom** metodin ***setTreadles(Grid)*** sisälle, jolloin sovelluslogiikan luokan Loom olio loom siis asettaa tuon parametrin kangaspuiden polkusten sidonnaksi.
