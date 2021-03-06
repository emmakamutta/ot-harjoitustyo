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

Jokainen näistä on oma Scene-olionsa, joka sijoitetaan vuorollaan sovelluksen stageen. Kunkin Scenen luomisesta vastaa oma metodinsa, jotka kaikki sijaitsevat luokassa [emmakamutta.ui.Ui](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/kudontasovellus/src/main/java/emmakamutta/ui/Ui.java). Aloitusnäkymästä vastaa metodi ***createWelcomeScene()***, kangaspuiden määrittelynäkymän taas luo metodi ***createCustomizeScene()*** ja kudontanäkymän luo metodi ***createWeaveScene()***.

Käyttöliittymä on pyritty eriyttämään sovelluslogiikasta. Se kutsuukin lähinnä sovelluslogiikan oliota [Loom](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/kudontasovellus/src/main/java/emmakamutta/domain/Loom.java) ja tämän metodeja sovelluslogiikan suorittamiseksi.

Käyttöliittymän kudontanäkymä pohjautuu pitkälti neljään erilaiseen ruudukkoon ja useisiin nappeihin. Kunkin ruudukon toiminnasta vastaa oma luokkansa. Ne löytyvät pakkauksesta emmakamutta.ui. Jokainen näistä luokista perii valmiin JavaFX luokan [GridPane](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/GridPane.html), sillä sen päälle oli hyvä rakentaa ruudukoitten erityisempiä toiminnallisuuksia. 

Tässä sovelluksessa tallentaminen on myös toteutettu osana käyttöliittymää, sillä tallentaminen on toteutettu vain png-kuvana käyttöliittymänäkymästä. Siitä siis vastaa luokan emmakamutta.ui.Ui metodi ***saveAsImage(Scene)***. Sen sisässä tallennus on toteutettu käyttämällä javafx.stage oliota [FileChooser](https://docs.oracle.com/javase/8/javafx/api/javafx/stage/FileChooser.html) ja ulkoista [JavaFx Swing](https://mvnrepository.com/artifact/org.openjfx/javafx-swing) -kirjastoa, jonka avulla käyttöliittymäkuva voidaan muuntaa png-muotoon.

## Sovelluslogiikka

Sovelluslogiikka koostuu neljästä eri luokasta ja rajapinnasta [Grid](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/kudontasovellus/src/main/java/emmakamutta/domain/Grid.java). Eri luokat kuvaavatkangaspuita ja sen osia. Koska ohjelmassa kangaspuun osat on toteutettu sovelluslogiikankin osalta erilaisina ruudukkoina, perivätkin suurin osa luokista rajapinnan Grid, joka tarjoaa metodit ***getRow(int)*** ja ***getColumn(int)***. Lisäksi luokat [Fabric](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/kudontasovellus/src/main/java/emmakamutta/domain/Fabric.java) ja [Heddles](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/kudontasovellus/src/main/java/emmakamutta/domain/Heddles.java) perivät luokan [UniversalGrid](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/kudontasovellus/src/main/java/emmakamutta/domain/UniversalGrid.java), sillä ne ovat tämän yleisemmän ruudukon erikoistapauksia laajemmalla toiminnallisuudella. 

![luokkakaavio](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/luokkakaavio.png)

Luokka [Loom](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/kudontasovellus/src/main/java/emmakamutta/domain/Loom.java) hallinnoi pitkälti kangaspuiden toimintaa. Aivan kuten oikeissakin kangaspuissa itse puut sisältävät pienempiä osasia, jotka vaikuttavat niiden toimintaan. Siispä luokka Loom on sisältää oliomuuttujina muut sovelluslogiikan luokat. Loom myös vastaa kangaspuiden päätoiminnallisuudesta, eli kutomisesta, metodilla ***weave(int)***. Lisäksi Loom osaa myös purkaa kutomistaan metodilla ***undo()***. 

## Päätoiminnallisuutta
Seuraavat sekvenssikaaviot kuvaavat joitakin ohjelman päätoiminnallisuuksia. Sekvenssikaavioista on jätetty joitakin metodien sisäisiä epäolennaisempia toimintoja merkitsemättä täysin tarkasti selkeyden vuoksi.

### Käytettävien kangaspuiden konfigurointi
Seuraava sekvenssikaavio esittää sitä, kun käyttäjä määrittelee kangaspuut, joissa on 4 niisivartta, 4 polkusta ja kankaan leveys on 20, ja tämän jälkeen klikkaa nappia "Luo" kangaspuiden määrittelynäkymässä.

![määrittelysekvenssi](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/luontisekvenssi.png)

Napin painaminen siis aiheuttaa sen, että Ui hakee kunkin määriteltävän arvon niitä vastaavista liu'uttimista. Sitten se luo uuden Loom-olion näiden arvojen pohjalta. Tämän jälkeen Ui kutsuu omaa metodiaan ***createWeaveScene()***, joka luo konfiguroiduille kangaspuille sopivan kudontanäkymän, ja asettaa sen näkyviin.

### Polkusten sidonnan määrittely
Kun käyttäjä on klikkaillut polkusten sidonnan haluamakseen ja varmistaa sen painamalla "Lukitse sidonta" -nappia, tapahtuu seuraava.
![sekvenssi](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/polkusten_varmistussekvenssi.png)

Käyttöliittymän tapahtumakäsittelijä kutsuu luokan treadlesPane metodia ***setModifiable(false)***, joka lukitsee sidontaruudukon muutoksilta. Sen jälkeen se kutsuu saman luokan metodia ***convertToTreadles()***. Tämä metodi palauttaa uuden UniversalGrid-olion, joka vastaa visualisaatiota Grid muodossa. Tämä olio asetetaan sitten olion **loom** metodin ***setTreadles(Grid)*** sisälle, jolloin sovelluslogiikan luokan Loom olio loom siis asettaa tuon parametrin kangaspuiden polkusten sidonnaksi tarkastettuuaan ensin, että se on kangaspuihin sopiva. Tämän jälkeen kutsutaan olion **treadlesPane** metodia ***setLockedColors()***, joka vaihtaa sovelluksen näkymässä polkusten sidontaruudukon mustat ruudut tummanharmaiksi lukitsemisen merkiksi.

Niisinnän määrittely toimii vastaavalla tavalla.

### Kutominen
Tämä sekvenssikaavio kuvaa sitä, kuinka polkusten sidonnan ja niisinnän määrittelyjen jälkeen painetaan ensimmäistä polkusta kuvaavaa nappia.

![kudontasekvenssi](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/kutomissekvenssi.png)

Siis kun painetaan polkusnappia, Ui tarkistaa ensin oliomuuttujasta, ovatko kangaspuut kudontavalmiit (siis onko niisintä ja polkusten sidonta määritelty). Tämän jälkeen kutsutaan luokan **Loom** metodia ***weave(0)***, joka ensin tarkastaa onko kyseistä polusta edes olemassa, ja sitten onko sillä aiemmin kudottu. Tässä tapauksessa ei ole, joten polkusta painamalla syntymää kudottua riviä ei löydy valmiiksi hashMapista **weaveTreadles**. Siis **loom** kutsuu omaa metodiaan ***getWeavedRow(0)***, joka palauttaa tuon kyseisen rivin. Tämä sitten laiteaan hashMappiin seuraavan rivin kutomisen yksinkertaistamiseksi. Tämän jälkeen kudottava rivi haetaan HashMapista **weaveTreadles** ja merkitään kudottvaan kankaaseen kutsumalla olion **fabric** metodia ***weaveRow(int[])***. Myös poljettu polkunen laitetaan muistiin lisäämällä se poljentajärjestyksestä vastaavaan ArrayDequeen **treadOrder**. Kun rivin kutominen on näin suoritettu sovelluslogiikan puolella, antaa Ui sitten käskyn näyttää kutomisjälki kankaan visualisoimisesta vastaavalle oliolle **fabricPane**. Siis kutsutaan sen metodia ***visualizeFabric(Fabric)***, joka saa siis parametrina visualisoitavan kankaan. Tämän jälkeen vastaavasti visualisoidaan myös poljentajärjestys kutsumalla käyttöliittymän luokan **treadOrderPane** metodia ***visualize(0)***.

### Viimeisimmän rivi purkaminen
Tämä sekvenssikaavio kuvaa sitä, kuinka viimeisin kudottu rivi puretaan painamalla "Peruuta"-nappia. Sekvenssissä oletetaan, että viiimeisin rivi oli 5. kudottu rivi. 

![purkamissekvenssi](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/purkamissekvenssi.png)

Siis napin klikkaamisen jälkeen ui ensin tarkastaa käytettäviltä kangaspuilta, kuinka monta riviä on jo kudottu. Jos vielä ei olisi kudottu yhtäkään riviä, metodi ei tämän jälkeen tekisi mitään, sillä tyhjää on mahdoton purkaa. Tätä tarkistusta ei ole merkitty tarkasti kaavioon. Sen jälkeen Ui kutsuu oliota **loom** metodilla ***undo()***.
Nyt **loom** puolestaan vielä tarkastaa, ettei vain polkusten polkemisjärjestys ole tyhjä, siis purettavan rivin olemassaolo tarkastetaan uudelleen. Tämän jälkeen **loom** kutsuu olion **fabric** metodia ***unWeave()***, joka poistaa kankaasta viimeisimmän rivin. Sen jälkeen **loom** poistaa myös viimeisimmän polkusen poljentajärjestyksen muistamisesta vastaavasta jonosta **treadOrder**. Tämän jälkeen purkaminen on suoritettu sovelluslogiikan osalta - siis Ui:n täytyy vielä visualisoida muutokset. Tämä käy siten, että Ui kutsuu jälleen kangasta visualisoivan luokan **fabricPane** metodia ***visualizeFabric(fabric)*** ja sen jälkeen poljentajärjestystä visualisoivan luokan **treadOrderPane** metodia ***clearLatestRow()***, joka tyhjentää poljentajärjestysruudukon viimeisimmän rivin. 

### Muu toiminnallisuus
Sovelluksen muu toiminnallisuus on toteutettu hyvin samankaltaisesti, kuin yllä mainitut. Kaikki sovellukset toiminnot siis käynnistyvät, kun käyttäjä painaa jotakin nappia. Tämä saa käyttöliittymän tekemään jotakin, ja yleensä jos toiminnallisuus vaatii jotakin sovelluslogiikalta, ui kutsuu ensin luokan Loom oliota, sillä Loom vastaa pääosin sovelluslogiikan ja käyttöliittymän keskustelusta. 


## Ohjelmaan jääneet heikkoudet

### Käyttöliittymä
Käyttöliittymästä vastaavan luokan Ui metodit jäivät melko pitkiksi, joten niitä olisi varmaan voinut jakaa vielä pienemmiksi metodeiksi ja kentien jopa omiksi luokikseen. Lisäksi kudontanäkymän osasista vastaavat käyttöliittymäluokat sisältävät osittain samankaltaisia tai toiminnallisuudeltaan samoja metodeja, siis niille olisi voinut koodata vielä ainakin yhden yliluokan.

### Tallentaminen
Sovelluksen tallentaminen tuli toteutettua vain näyttökuvana kudontanäkymästä. Vaikka tämä on sovelluksen käyttötarvetta ajatellen riittävää, ohjelmaan olisi kenties sopinut vielä paremmin lisätallennusmuoto, jossa kudontamalleja pääsisi muokkaamaan ja tarkastelemaan uudestaan. Tällöin olisi ollut myös tarvetta kokonaan omalle pakkaukselle Dao, joka jäi nyt sovelluksesta puuttumaan, sillä nyt tallennus on toteutettu selkeyden vuoksi vain käyttölittymässä. Tämän lisäksi myös nykyistätallennusmuotoa olisi voinut parantaa siten, että ohjelma rajaisi tallennettavasta kuvasta pois sovelluksen napit, sillä ne eivät oikein tuo tallennettavalle kudontamallille lisäarvoa.

