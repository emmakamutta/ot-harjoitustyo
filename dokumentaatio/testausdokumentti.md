# Testausdokumentti

Sovellusta on testattu niin automaattisesti JUnitin avulla, kuin manuaalisesti käyttöliittymän osalta.

## Sovelluslogiikka

Sovelluksen sovelluslogiikkaa on testattu automaattisesti testipakkauksen sisältä löytyvillä testiluokilla JUnitin avulla. Kaikki testiluokat löytyvät testipakkauksen [*domain*](https://github.com/emmakamutta/ot-harjoitustyo/tree/master/kudontasovellus/src/test/java/domain) sisältä. Testiluokat [*FabricTest*](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/kudontasovellus/src/test/java/domain/FabricTest.java), [*HeddlesTest*](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/kudontasovellus/src/test/java/domain/HeddlesTest.java) ja [*UniversalGridTest*](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/kudontasovellus/src/test/java/domain/UniversalGridTest.java) testaavat vastaavien sovelluslogiikan luokkien sisäistä toimintaa. 
Koska luokka [*Loom*](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/kudontasovellus/src/main/java/emmakamutta/domain/Loom.java) kokoaa eri sovelluslogiikan olioita yhteen, testaa sen testiluokka [*LoomTest*](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/kudontasovellus/src/test/java/domain/LoomTest.java) myös muiden sovelluslogiikan luokkien toimintaa yhdessä luokan *Loom* testaamisen kanssa. Tämän lisäksi testiluokka [*EverythingTogetherTest*](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/kudontasovellus/src/test/java/domain/EverythingTogetherTest.java) testaa koko sovelluslogiikan toimintaa yhdessä. 

## Testikattavuus

![testikattavuskuva](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/testikattavuuskuva.png)

Testauksen rivikattavuus on 100% ja haaraumakattavuus 92%. Haaraumakattavuudesta jäi testaamatta tapaukset, joissa luokan *Loom* metodeja *setHeddles* ja *setTreadles* kutsuttaisiin väärän kokoisilla ruudukoilla. 

Käyttöliittymää ei ole otettu mukaan testikattavussraporttiin.

## Käyttöliittymä

Käyttöliittymää on testattu manuaalisesti niin monella erilaisella skenaariolla, kuin testaaja on sattunut keksimäänkään. Kaikiki [vaatimusmäärittelyssä](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md) ja [käyttöohjeessa](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md) kuvattu toiminnallisuus on käyty läpi. Sovellusta on myös yritetty käyttää tahallaan virheellisesti.

Sovelluksen asennusta on kokeiltu Windows-järjestelmää käyttävällä tietokoneella käyttöohjeen mukaisesti.
