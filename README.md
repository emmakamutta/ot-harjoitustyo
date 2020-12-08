# Ohjelmistotekniikka

## Harjoitustyö - Kudontasovellus
Sovelluksen avulla voi suunnitella omia kudontamalleja määrittelemällä ensin käytettävät kangaspuut ja sitten suunnittelemalla malliin tulevan niisinnän ja polkusten sidonnan.
Kudottua pintaa voi mallintaa kokeilemalla erilaisia polkemisjärjestyksiä ja siten simuloida kutomista suunnittelemallaan mallilla.

### Release 1 viikolla 5

* [release 1](https://github.com/emmakamutta/ot-harjoitustyo/releases/tag/viikko5)

### Dokumentaatio

* [arkkitehtuuri](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)
* [vaatimusmäärittely](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)
* [tuntikirjanpito](https://github.com/emmakamutta/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)


### Hyödyllisiä Maven-komentoja

* testaus  `mvn test`
* testikattavuusraportti `mvn jacoco:report` - löytyy avaamalla selaimella tiedosto *target/site/jacoco/index.html*
* checkstyle-raportti `mvn jxr:jxr checkstyle:checkstyle` - löytyy avaamalla selaimella tiedosto *target/site/checkstyle.html*
* suoritettavan jarin generointi `mvn package` - suoritettava jar löytyy hakemiston *target* alta päätteellä *.jar*
* JavaDocin luonti `mvn javadoc:javadoc`- JavaDoc löytyy hakemistosta target/site/apidocs/
