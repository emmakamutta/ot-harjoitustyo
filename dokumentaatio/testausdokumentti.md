# Testausdokumentti

Sovellusta on testattu niin automaattisesti JUnitin avulla, kuin manuaalisesti käyttöliittymän osalta.

## Sovelluslogiikka

Sovelluksen sovelluslogiikkaa on testattu automaattisesti testipakkauksen sisältä löytyvillä testiluokilla JUnitin avulla. Kaikki testiluokat löytyvät testipakkauksen domain sisältä. Testiluokat *FabricTest*, *HeddlesTest* ja *UniversalGridTest* testaavat vastaavien sovelluslogiikan luokkien sisäistä toimintaa. 
Koska luokka *Loom* kokoaa eri sovelluslogiikan olioita yhteen, testaa sen testiluokka *LoomTest* myös muiden sovelluslogiikan luokkien toimintaa yhdessä luokan *Loom* testaamisen kanssa. Tämän lisäksi testiluokka *EverythingTogetherTest* testaa koko sovelluslogiikan toimintaa yhdessä. 

## Testikattavuus

![testikattavuskuva](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/testikattavuuskuva.png)

Testauksen rivikattavuus on 100% ja haaraumakattavuus 92%. Haaraumakattavuudesta jäi testaamatta tapaukset, joissa luokan *Loom* metodeja *setHeddles* ja *setTreadles* kutsuttaisiin väärän kokoisilla ruudukoilla. 

Käyttöliittymää ei ole otettu mukaan testikattavussraporttiin.

## Käyttöliittymä

Käyttöliittymää on testattu manuaalisesti niin monella erilaisella skenaariolla, kuin testaaja on sattunut keksimäänkään. Kaikiki vaatimusmäärittelyssä ja käyttöohjeessa kuvattu toiminnallisuus on käyty läpi. Sovellusta on myös yritetty käyttää tahallaan virheellisesti.

Sovelluksen asennusta on kokeiltu Windows-järjestelmää käyttävällä koneella käyttöohjeen mukaisesti.
