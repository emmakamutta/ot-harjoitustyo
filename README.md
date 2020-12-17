# Ohjelmistotekniikka

## Harjoitustyö - Kudontasovellus
Sovelluksen avulla voi suunnitella omia kudontamalleja määrittelemällä ensin käytettävät kangaspuut ja sitten suunnittelemalla malliin tulevan niisinnän ja polkusten sidonnan.
Kudottua pintaa voi mallintaa kokeilemalla erilaisia polkemisjärjestyksiä ja siten simuloida kutomista suunnittelemallaan mallilla.

### Releaset 

* [release 1 (vko 5)](https://github.com/emmakamutta/ot-harjoitustyo/releases/tag/viikko5)
* [release 2 (vko 6)](https://github.com/emmakamutta/ot-harjoitustyo/releases/tag/Viikko6)
* [Loppupalautus](https://github.com/emmakamutta/ot-harjoitustyo/releases/tag/palautus)

### Dokumentaatio

* [käyttöohje](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)
* [vaatimusmäärittely](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)
* [arkkitehtuuri](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)
* [testausdokumentti](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/testausdokumentti.md)
* [tuntikirjanpito](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)


### Hyödyllisiä Maven-komentoja

* testaus  `mvn test`
* testikattavuusraportti `mvn jacoco:report` - löytyy avaamalla selaimella tiedosto *target/site/jacoco/index.html*
* checkstyle-raportti `mvn jxr:jxr checkstyle:checkstyle` - löytyy avaamalla selaimella tiedosto *target/site/checkstyle.html*
* suoritettavan jarin generointi `mvn package` - suoritettava jar löytyy hakemiston *target* alta päätteellä *.jar*
* JavaDocin luonti `mvn javadoc:javadoc`- JavaDoc löytyy hakemistosta target/site/apidocs/
