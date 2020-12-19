# Kangaspuiden toiminnasta ja kudontamallin lukemisesta
Sovellukseni pyrkii kuvaamaan kangaspuiden toimintaa. Aihe tuskin on aiheeseen perehtymättömille kovin tuttu, joten tässä on  yksinkertaistettu perehdytys aiheeseen. Olen merkinnyt sovelluksen kannalta olennaisia termejä **lihavoituna**.


Kangaspuissa on paljon eri osasia, joilla on jokaisella oma tehtävänsä kokonaisuudessa. Kudottua kangasta suunniteltaessa tärkeimmät osaset ovat kuitenkin **polkuset** sekä **niisivarret**. Niiden lukumäärää ja niihin liittyviä yksityiskohtia muuttamalla mahdollistetaan erilaisten kankaiden pintojen ja kuvioiden kutominen.

Kangaspuilla kudottu kangas koostuu kahdensuuntaisista langoista; pystysuoraan kulkevista loimilangoista ja vaakasuoraan kulkevasta kuteesta. Näiden lankojen muodostamista erilaisista kuvioista käytetään termiä kankaan **sidos**. Sidos muodostuu kutoessa, ja riippuu kangaspuiden kudontavalmiiksi laittessa määritellystä **niisinnästä** ja **poljennasta**, eli siitä mikä polkunen on painettu alas ennen yhden rivin kutomista, eli yhtä kuteen heittoa. 


Itse kutominen toimii siis siten, että ensin jalalla painetaan jokin **polkusista** alas. Tämä aiheuttaa sen, että jotkin kangaspuiden **niisivarsista** nousevat ylös. Niisivarsista roikkuu niisiä, jotka ovat tavallaan lankalenkkejä, joiden läpi yksittäiset loimilangat kulkevat. Siis kun jokin niisivarsi nousee ylös, myös osa loimilangoistakin nousee ylös ja osa taas jää alas. Siten loimen keskelle muodostuu viriö, eli tavallaan eräänlainen tunneli, jonka läpi kude voidaan pujottaa. Silloin siis kudottu kankaan rivi näyttää siltä, että ylös nousseet loimilangat näkyvät kankaan pinnassa ja alas jääneiden loimilankojen kohdalla on näkyvissä kude. Siten syntyvää kankaaan pintaa onkin helppo ajatella ruudukkona, jossa musta ruutu on näkyvä loimilanka ja valkoinen ruutu taas kude.


  Termi **niisintä** siis tarkoittaa sitä, kun määritellään mitkä loimilangoista menevät minkäkin niisivarren niisien läpi. Jotta kangaspuut toimisivat kunnolla, tulee kunkin loimilangan nousta vain yhden niisivarren mukana, muuten saattaisi käydä niin, että niitä revittäisiin samaan aikaan sekä ylös, että alas. Niisintääkin voi ajatella ruudukkona - ruudukon jokainen rivi vastaa yhtä niisivartta ja jokainen ruutu yhtä loimilankaa. Jos jollain rivillä on musta ruutu, se tarkoittaa, että lanka nousee niisivarren mukana. 
  
  
  Poljentajärjestyksen lisäksi kankaan sidokseen vaikuttaa myös **polkusten sidonta**, jonka avulla määritellään mitkä niisivarret nousevat ylös mitäkin polkusta painettaessa. Koska jokainen niisivarsi nousee itsenäisesti, voi yhdestä polkusesta nousta useampi niisivarsi.  Myös polkusten sidonnan voi merkitä ruudukkoon - ruudukon rivit ovat jälleen niisivarsia ja sarakkeet polkusia. Jos polkusessa on niisivarren kohdalla musta ruutu, se tarkoittaa, että se niisivarsi jää poljettaessa alas.
  
**Siis vielä yksinkertaistettuna yhden kudotun rivin kuvio muodostuu seuraavasti:**
1. Jokin polkunen painetaan alas.
2. Valkoiseksi merkityt niisivarret nousevat ylös, mustat jäävät alas.
3. Kun kude pujotetaan, ylös nousseiden niisivarsien mustat ruudut jäävät näkyviin kankaan pintaan mustina.

**Siis tietojenkäsittelijän näkökulmasta kutomisen voi rinnastaa XOR-bittioperaatioon. Jos jokaisen niisivarren niisntä olisi määritelty ruudukon rivin sijasta binäärinä, niin polkusten sidonta kertoo, että kun jotakin tiettyä polkusta painetaan, mistä niisintäbinääreistä otetaan XOR. Tulos on kudotun rivin ulkonäkö.**

## Pieni kudontasanasto Suomi-Englanti
- niisi - heddle
- niidet/niisintä - heddles 
- polkuset - treadles
- loimi - warp
