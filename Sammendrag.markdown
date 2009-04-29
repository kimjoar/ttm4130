Sammendrag av TTM4130 - Tjenesteintelligens og mobilitet
========================================================

Sammendraget er basert på læringsmålene i faget, og tar utgangspunkt i fagets kompendium og forelesningsfoiler, samt delvis ekstramaterialet spesifisert i læringsmålene.

(Deler av stoffet er kopiert fra ekstrematerialet, Wikipedia, eller andre kilder, og det er derfor mye blanding av norsk og engelsk i dette dokumentet.)

Know the difference between access network, transport network and service platform/IN
-------------------------------------------------------------------------------------

* Et moderne kommunikasjonssystem består av et aksessnett og et kjernenett, der kjernenettet gjerne deles i to nivåer, tjenesteplattform og transportnett.
* I transportnettet formidles nytteinformasjon, "budskapet", mellom deltagerne.
* Tjenesteplattformen blir anvendt for oppsetning, styring og kontroll av transportstrømmene.
* Utviklingen av tjenesteplattformen har kulminert i IN, som standardiserer funksjoner i tjenestestyringslaget.
* An access network is that part of a communications network which connects subscribers to their immediate service provider (tjenesteleverandør). 
* Det eksisterer to hovedutgaver av tjenesterealiseringsnett i Europa:
  * Intelligent Networks
  * GSM-tjenesteplattform
* Både IN- og GSM-rammeverket er uenget når mobile brukere ønsker integrering av webbaserte tjenester med vanlig telefoni, med fokus på multimedia-innhold.

Be familiar with modeling of a normal telephone calls states, and how to illustrate this by state descriptions and sequence diagrams
------------------------------------------------------------------------------------------------------------------------------------

Vanskelig å få tilgang til terminaltilstanden til en telefon direkte, og overvåker derfor samtaletilstanden:

* SBCP (Subscriber Basic Call Process). Ligger i endesentralene.
* TBCP (Transit Basic Call Process). Ligger i transittsentralene, tilsluttet hver enkelt inngang.

Realiseres i form av tilstandsmaskiner. Hver enkelt abonnentlinje må ha sin egen tilstandsmaskin.

Minst tre forskjellige nivåer av informasjon for å overvåke tilstanden i nettet:

* Nettets driftstilstand, inklusive den enkelte komponent.
* Rutingtabeller.
* Den enkelte forbindelse eller oppkobling.

Be familiar with the Intelligent Network architecture
-----------------------------------------------------

* The term Intelligent Networks (IN) is used to describe an architectural concept which is intended to be applicable to all telecommunications networks and aims to ease the introduction and management of new services.
* With IN technology it is possible to introduce new services rapidly without affecting the available services. IN defines a large set of standards that describe the interfaces between different network control points. With only specifying the interfaces IN makes it possible for vendor systems to provide with different products and, of course, for operators to use any of these products in their network configuration.
* The Intelligent Network is a network architecture intended both for fixed as well as mobile telecom networks. It allows operators to differentiate themselves by providing value-added services in addition to the standard telecom services such as PSTN, ISDN and GSM services on mobile phones.
* In IN, the intelligence is provided by network nodes owned by telecom operators, as opposed to solutions based on intelligence in the telephone equipment, or in Internet servers provided by any part.
* IN is based on the Signaling System #7 (SS7) protocol between telephone network switching centers and other network nodes owned by network operators.
* The main concepts (functional view) surrounding IN services or architecture are connected with SS7 architecture.
* IN er et distribuert system for tjenestestyring.
* IN has not replaced the existing PSTN; rather, it has been overlaid onto it.
* The standards define a complete architecture including the architectural view, state machines, physical implementation and protocols. 
* Before IN was developed, all new feature and/or services that were to be added had to be implemented directly in the core switch systems. This made for very long release cycles as the bug hunting and testing had to be extensive and thorough to prevent the network from failing. With the advent of IN, most of these services were moved out of the core switch systems and into self serving nodes (IN), thus creating a modular and more secure network that allowed the services providers themselves to develop variations and value-added services to their network without submitting a request to the core switch manufacturer and wait for the long development process.
* IN kan grovt sett sees som en tjenesteplattform som "utvider" transportnettet.
* Konseptuell modell i fire nivåer/plan. Each plane introduces an abstract view of the network entities, which is further made tangible in the plane below it. Tolkes top/down:
  1. Service plane. Abstrakt spesifikasjonslag. Tjenester beskrives ved hjelp av generelle blokker kalt Service Features (SF). En tjeneste er et selvstendig kommersielt tilbud, og en tjenesteegenskap (SF) beskriver et spesielt aspekt ved en tjeneste. Tjeneste og funksjoner realiseres ved hjelp av funksjoner fra nest øverste plan, såkalte Service Independent Blocks (SIB).
  2. Global functional plane. Delt i to deler. 
     * Global tjenestelogikk som styrer instanser av SIB-er. Samlingen av disse representerer et bibliotek som kan anvendes til å realisere tjenester. Tjenestelogikken spesifiserer hvordan et utvalg av slik funksjonalitet skal manøvreres for å skape en tjeneste. The SIBs are reusable components that can be chained together to construct a service logic. En enkelt SIB er en prosess som kan motta data, deretter prosessere denne, for så å overlevere til neste trinn i i kjeden.
     * ... Basic Call Processing (BCP) er et særtilfelle av en SIB. Utførelsen av en tjeneste starter og ender i BCP.
  3. Distributed functional plane. Inneholder en beskrivelse av hvordan SIB-funksjonalitet skapes ved hjelp av Functional Entities (FE). FE-kan distribueres i nettet, men én enkelt FE kan ikke distribueres. Altså kan FE-ene til én SIB være distribuert. Hver FE må utføre en Functional Entity Action (FEA), som er realisert ved hjelp av Elementary Functions (EF). Informasjonsflyten mellom flere FE-er går via FEA-ene. SIBs are realized by a sequence of FEAs in an FE. For at en gruppe funksjonelle enheter skal kunne realisere en SIB må de ha de nødvendige egenskaper og kunne samarbeide.
  4. Physical plane. Protokoller og prosessering som beskriver fordelingen av fysiske enheter i nettet. The FEs of the distributed functional plane are mapped to Physical Entities (PE). PEs communicate with each other by exchanging protocol messages (represented by information flows in the distributed functional plane). Describes the physical architecture alternatives for an IN-structured network in terms of potential physical systems, referred to as physical entities (PE), in a network, and interfaces between these PEs. The physical plane architecture describes how functional architecture map into Physical Entities and interfaces.
* The IN’s main advantage is the ability to control switching and service execution from a small set of Intelligent Network nodes known as Service Control Points (SCP). SCPs are connected to the network switches (known as Service Switching Points (SSP)) via a standardized interface; Signalling System No. 7.
* The SSPs detect when the SCP should handle a service. The SSP forwards a standardized SS7 (TCAP) message containing relevant service information. Via the TCAP message, the service control logic in the SCP directs the SSPs to perform the individual functions that collectively constitute the service.
* An Intelligent Network is able to separate the specification, creation, and control of telephony services from physical switching networks.

An IN-compliant service is first constructed through an FE called the Service Creation Environment Function (SCEF). This FE contains the programming environment, which includes the SIB that a programmer uses to construct an IN-compliant service. Once the service logic is created and tested, it is sent to another FE, the service management function (SMF). This FE deploys the service logic to the service execution FEs and allows for service customization. 

![Konseptuell IN-modell](in-conceptual-model.png)
![Konseptuell IN-modell](in-conceptual-model-2.gif)
![Nettverksarkitektur IN](in-network-architecture.gif)
![Funksjonelle enheter](in-distributed-functional-plane-model.png)

Be familiar with and be able to describe the mode of operations for the most important IN physical and functional entities, including SSP, STP, SCP, SDP and SMF, and what IP indicates in this context/relation. 
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

![PEs and FEs](pe-and-fe.png)

Disse enhetene er stort sett forbundet ved hjelp av SS7-signalisering.

### Service Switching Function (SSF) or Service Switching Point (SSP)

* Co-located with the telephone exchange itself, and acts as the trigger point for further services to be invoked during a call.
* Implements the Basic Call State Machine (BCSM). 
* As each state is traversed, the exchange encounters Detection Points (DPs) at which the SSP may invoke a query to the SCP to wait for further instructions on how to proceed. This query is usually called a trigger. Trigger criteria are defined by the operator and might include the subscriber calling number or the dialled number. The SSF is responsible for entertaining calls requiring value added services.
* Innføring av nummerportabilitet gjør at man må konsultere enn database ved alle oppringninger, altså må man inn i IN ved hver oppringning.

### Service Control Function (SCF) or Service Control Point (SCP) 

* Separate set of platforms that receive queries from the SSP. 
* The SCP contains service logic which implements the behaviour desired by the operator, i.e., the services. 
* During service logic processing, additional data required to process the call may be obtained from the SDF. 
* The logic on the SCP is created using the SCE.
* Enhet som styrer tjenesten.
* Inneholder tjenestestyringslogikk som avgjør hvordan en innkommende henvendelse skal tolkes, hvilke parametre som trenger å hentes inn gjennom oppslag i SDP, og hvordan den videre gang blir.
* The SSP contains Detection Capability to detect requests for IN services. It also contains capabilities to communicate with other PEs containing SCF, such as SCP, and to respond to instructions from the other PEs.
* In case of external Service Data Point (SDP) the SCF can access data through a signalling network.
* The SDP may be in the same network as the SCP, or in another network.
* SCF styrer prosessering av anropet ved henvendelser med IN-støttede funksjoner og/eller henvendelser fra bruker.

### Service Data Function (SDF) or Service Data Point (SDP) 

* Database that contains additional subscriber data, or other data required to process a call. 
* The SDF may be a separate platform, or is sometimes co-located with the SCP.

### Service Creation Environment (SCE) 

* Development environment used to create the services present on the SCP. 
* Proprietary graphical languages have been used to enable telecom engineers to create services directly. The user can use Graphical Interface to manipulate between different functions to formulate a service.
* Samsnakker med SMP.

### Specialized Resource Function (SRF) or Intelligent Peripheral (IP) 

* This is a node which can connect to both the SSP and the SCP and delivers additional special resources into the call, mostly related to voice data, for example play voice announcements or collect DTMF tones from the user.
* Enhet utstyrt med tonesender/-mottaker, opptaker/avspiller for kunde- og systemgenererte meldinger.
* An SCP or Adjunct can request an SSP to connect a user to a resource located in an IP that is connected to the SSP from which the service request is detected. An SCP or Adjunct can also request the SSP to connect a user to a resource located in an IP that is connected to another SSP.

### Signal Transfer Point

* Enhet/ruter for signaleringstrafikk. Fordeler signaleringstrafikken mot SCP på en hensiktsmessig måte.

### Adjunct (AD)

* Samme funksjonalitet som SCP, men betjener bare én sentral. Har ofte egen SDP, og er som oftest samlokalisert med en trafikksterk sentral.

### Network Access Point (NAP)

* Sentral uten IN-funksjoner.
* Må benytte seg av SSP-utstyr i andre sentraler for å få tilknytning.
* This NAP cannot communicate with an SCF, but it has the ability to determine when IN processing is required. It must send calls requiring IN processing to an SSP.

### Service Node (SN)

* Separat sammensatt node med en rekke funksjoner, satt sammen for å dekke lokalt behov. Stort sett samme funksjonalitet som en SSP, men ikke tilknyttet en sentral, altså kan den ikke behandle "normale" anrop.

Know what Signalling System No 7 is and how it is used
------------------------------------------------------

* SS7 er et felleskanalsystem (CCS)
* Signaling System Number 7 (SS7) is a set of telephony signaling protocols which are used to set up most of the world's public switched telephone network telephone calls. 
* The main purpose is to set up and tear down telephone calls. Other uses include number translation, prepaid billing mechanisms, short message service (SMS), and a variety of other mass market services.
* SS7 skaper språket og kommunikasjonssystemet for å overføre meldinger, men det trengs enheter i nettet som tolker disse meldingene og reagerer på hensiktsmessig måte.
* The term signalling, when used in telephony, refers to the exchange of control information associated with the establishment of a telephone call on a telecommunications circuit.
* To typer signalering:
  1. Channel Associated Signaling. With CAS signaling, this routing information is encoded and transmitted in the same channel as the payload itself.
  2. Common Channel Signaling. With CCS signaling information (control information) is transmitted on a separate channel to the data, and, more specifically, where that signaling channel controls multiple data channels.
* The path and facility used by the signalling is separate and distinct from the telecommunications channels that will ultimately carry the telephone conversation.
* SS7, being a high-speed and high-performance packet-based communications protocol, can communicate significant amounts of information when setting up a call, during the call, and at the end of the call. This permits rich call-related services to be developed.
* Due to its richness and the need for a completely separate signalling network for its operation, SS7 signalling is mostly used for signalling between telephone switches and not for signalling between local exchanges and Customer Premise Equipment (CPE).
* SS7 clearly splits the signaling planes and voice circuits. An SS7 network has to be made up of SS7-capable equipment from end to end in order to provide its full functionality.
* The SS7 protocol stack borrows partially from the OSI Model of a packetized digital protocol stack. OSI layers 1 to 3 are provided by the Message Transfer Part (MTP) and the Signalling Connection Control Part (SCCP) of the SS7 protocol. Currently there are no protocol components that provide OSI layers 4 through 6. The User Part provides layer 7.
* SS7 skreddersyr rutiner helt fra fysisk lag og opp.
* To deler:
  * Message transfer part. Beskriver virkemåte for fysisk lag, linklag og nettverkslag. MTP sørger for at informasjonen fra UP blir transportert pålitelig på tvers av SS7-nettet. Connectionless. For tredje generasjons mobilnett erstattes MTP med IPv6, og lager i den forbindelse Stream Control Transport Protocol (SCTP), siden hverken TCP eller UDP har nok støttefunksjoner.
  * User part. Består av ISDN User Part, Telephone User Part, og Signaling Connection Control Part og Transaction Capabilities Application Part. Er brukere av MTP.
* SS7 kan brukes til å sammenbinde mange slags kommunikasjonssystemer.
* Stream Control Transmission Protocol (SCTP) is a Transport Layer protocol, serving in a similar role as the popular protocols Transmission Control Protocol (TCP) and User Datagram Protocol (UDP). Indeed, it provides some of the same service features of both, ensuring reliable, in-sequence transport of messages with congestion control.
* The Message Transfer Part (MTP) is divided into three levels:
  1. Equivalent to the OSI Physical Layer. Defines the physical, electrical, and functional characteristics of the digital signaling link.
  2. Equivalent to the OSI Data Link Layer. Ensures accurate end-to-end transmission of a message across a signaling link. Implements flow control, message sequence validation, and error checking.
  3. Equivalent to the OSI Network Layer. Provides message routing between signaling points in the SS7 network. Re-routes traffic away from failed links and signaling points and controls traffic when congestion occurs. 
* ISDN User Part (ISUP). Defines the protocol used to set-up, manage, and release trunk circuits that carry voice and data between terminating line exchanges.
* Signaling Connection Control Part (SCCP). Provides connectionless and connection-oriented network services.
* Transaction Capabilities Applications Part (TCAP). Supports the exchange of non-circuit related data between applications across the SS7 network using the SCCP connectionless service. Queries and responses sent between SSPs and SCPs are carried in TCAP messages.

![Comparison of transport layers](comparison-transport-layer.png)

Know what TMN is and what it is used for
----------------------------------------

(Telecommunications Management Network? s21)

Know the meaning of Terminal Mobility, Person Mobility and Service Mobility. Describing mobility handling in the GSM- and IP-world included. 
--------------------------------------------------------------------------------------------------------------------------------------------

Mobility Management is one of the major functions of a GSM or a UMTS network that allows mobile phones to work. The aim of mobility management is to track where the subscribers are, so that calls, SMS and other mobile phone services can be delivered to them.

* Terminalmobilitet: Terminalen kan bevege seg, mens tjenesten opprettholdes.
* Brukermobilitet: Brukeren kan være hvor han vil. Adgang til tjenester uavhengig av hvilken fysisk terminal som brukes.
* Sesjonsmobilitet: Kan beholde en aktiv sesjon, selv om terminal byttes.
* Tjenestemobilitet: Programvaremodler kan overføres fra en maskin til en annen.
* Personmobilitet: Tillatter en person å benytte tjenester som er tilpasset egne preferanser og abonnenter uavhengig av fysisk plassering og spesielt utstyr.
* Rollemobilitet: Flere roller/profiler. "Jeg vil være en person på jobb og en annen hjemme."
* Kontinuerlig mobilitet: Avbruddsfri tilgang på tjenester selv under flytting/bevegelse.
* Diskret mobilitet: Tjeneste avbrytes under flytting, men taes opp igjen etterpå. Kan f.eks. har kontinuerlig mobilitet innenfor et gitt dekningsområde, og diskret mobilitet mellom dekningsområder.
* Mobilitet medfører at man tar meg seg /flytter ressurser eller en forbindelse fra et sted i nettet til et annet.  Har da behov for entydig identifisering av terminalen i det nye nettet. I tillegg trenger man autorisasjon for å ta i bruk ressurser i det nye nettet. Og det trengs en rengskapsfunksjon som grunnlag for betaling. => AAA (Authentication, Authorization, Accouting)

### Mobilitetshåndtering i GSM

* Kan sees på som terminalmobilitet, men SIM-kortet kan flyttes til en ny terminal. => Brukermobilitet.
* Handover, kontunuerlig mobilitet. ...
* Home Location Register (HLR, abonnentregister) inneholder informasjon om tjenester det kan abonneres på, abonnentets status, og oppdatert oppholdsplass for abonnenten, altså hvilket Visiting Location Register (VLR, oppholdsregister) bruker er i.
* Roaming = En bruker kan bevege seg på tvers av operatørområder. Roaming is defined as the ability for a cellular customer to automatically make and receive voice calls, send and receive data, or access other services, including home data services, when travelling outside the geographical coverage area of the home network, by means of using a visited network.
* Terminalen scanner kontinuerlig området den befinner seg i, og rapporterer signalstyrke og andre data til BSC (Base Station Controller), som tar avgjørelsen om handover. Hard handover.

![Location updating procedure in GSM](location-update-gsm.png)

### Mobilitetshåndtering i IP

* Ligner GSM, men det heter Home Agent (HA) og Foreign Agent (FA) istedetfor hhv HLR og VLR. HA og FA er samplassert med lokale rutere.
* Nomade betegner en mobil vertsmaskin.
* Korrespondent brukes som betegnelse på en vertsmaskin som kommuniserer med nomaden.
* Dersom nomaden flyttes til et nytt område (et annet subnett), må den først registrere seg for FA. Adressen til FA finnes ved å lytte til Agent Announcements. Dersom det finnes en egnet FA, kan registreringen finne sted. FA oppdaterer HA om ny posisjon. Trafikk vil kapsles inn av HA, som sender det videre til FA, som pakker ut datagrammet og presenterer det i eget subnett med nomadens fast IP-adresse som destinasjon (tunnelering).
* Registrering hos FA har som regel en endelig varighet, og må fornyes, og dette er nomadens plikt å ha oversikt over.
* Trafikk til nomaden vil alltid rutes via HA.

#### IPv6

* Tilstandsløs tilordning: Tillater en nomade å selv finne seg en IP "care of"-adresse på et nytt sted. De siste 48 bit i en autokonfigurert adresse vil være lik ethernet-adressen til vertsmaskinen. Dette betyr at også Network Point of Attachment (NPA) er kjent. Vertsmaskinen kan så melde sin "care of"-adresse til egen HA gjennom en Binding Update-melding. Den virker da som sin egen FA.
* Ruteoptimalisering gir korresponderende node mulighet til å cache nomadens c/o-adresse, og triangulær ruting kan da unngås. 

### Mobilitetshåndtering i SIP

* Roaming:
  * Pre-call:
    * Nomade kan finne SIP-tjener via multicast REGISTER.
    * Nomade kan få IP-adresse av DHCP.
    * Nomade oppdaterer egen hjemmeserver og lokasjonstjener.
  * Mid-call:
    * Nomade oppnår ny IP-adresse (eks via DHCP), og sender ny INVITE eller RE-INVITE til korrespondent, med ny adresse og oppdatert sesjonsbeskrivelse.

![Ruteoptimalisering](optimize-route.png)

Be able to describe what AAA means and where these functions are used. To be able to give a simple explanation/characterization of the protocols Radius and Diameter 
--------------------------------------------------------------------------------------------------------------------------------------------------------------------

* Disse funksjonene blir viktigere etterhvert som den enkelte terminal og bruker tillates å operere i mange forskjellige nett, samt bruke et rikt tjenesteutvalg supplert fra mange leverandører.
* Autentisering og autorisering kreves ofte flere ganger, f.eks. for å bli registrert som bruker/abonnement, for å få nettadgang, og for å bruke et bestemt tjenesteutvalg.
* Vertikal -> horisontal integrasjon. Stor betydning med riktig utforming av AAA-funksjonalitet.
* To viktige fora for fastlegging: 3GPP som spesifiserer fremtidens mobilnett, og IETFS arbeidsgrupper for AA og Mobile IP.
* Terminologi:
  * Adminstrativt område: Samling av nettverk, datamaskinter og databaser under en felles administrasjon.
  * Betjening: Funksjonalitet som realiserer tjenestegrensesnittet mellom klienten og lokaldomenet.
  * Portvakt: Enhet som styrer/kontrollerer klientens adgang til nettet.
  * Avregning/Billing: Sette sammen og utstede faktura/regning.
  * Megler: Tiltrodd mellommann med tillit fra minst to andre AAA-tjenere, og som er i stand til å oppnå og yte sikringstjenester fra disse AAA-tjenerne.
  * Fremmeddomene: Administrativt domene besøkt av mobil IP-klient. 
  * Regnskapsføring/Accounting: Funksjonen å samle sammen informasjon om ressursbruk for senere bruk i trendanalyser, revisjon, fakturering eller fordeling av kostnader.
  * CDR (Charging Data Record): Kostnadsregistrering generert av nettelement for å gi underlag for regning.

### Authentication

* Fysisk adgang. Tradisjonell fasttelefoni.
* Terminalidentitet. NMT.
* Passord/PIN-kode
* Biometrisk data
* Flyttbart identitetskort. Brukes i GSM (SIM) og UMTS (USIM).

### Authorization

### Accounting

* Viktig element for å overvåke normal drift.
* Ideelt sett skal et system som medfører betaling for kunden også kunne produsere nøyaktig faktureringsgrunnlag. Kan kreve identifikasjon i flere trinn, f.eks. ved adgang til tilleggstjenester.

### Basismodell

![AAA-tjenere i hjemme- og lokaldomenet.](aaa-local-home-domain.png)

* Betjeningsnoden (NAS/FA/B) har ofte ikke direkte adgang til data som trengs for å sluttføre transaksjonen. Konsulterer da en autoritet, som vanligvis ligger i det samme administrative domenet, for å skaffe seg bevis for at klienten har akseptable fullmakter.
* Siden betjeningsnoden og den lokale autoritet tilhører samme administrative domene antas det at de har etablert, eller er i stand til å etablere, en sikker kanal som tillater utveksling av informasjon relatert til adgangskontroll.
* Når lokal autoritet ikke har nok informasjon til å verifisere klientens fullmakter forutsettes det at AAAL kan forhandle seg fram til verifikasjon ved hjelp av eksterne autoriteter.
* Det kan være mange betjeningsnoder i hvert administrative domene
* Enhver lokal betjeningsnode bør ha en sikkerhetsrelasjon med den lokale AAA-tjener (AAAL)
* Lokal autoritet må dele, eller dynamisk etablere, sikkerhetsrelasjoner med eksterne autoriteter som er i stand til å sjekke klientfullmakter.
* Betjeningsnoden må kunne holde rede på tilstand for klientforespørsler mens lokal autoritet kontakter passende ekstern autoritet.
* Siden den mobile node ikke nødvendigvis starter sin karriere med å være tilstede i eget hjemmedomene må den være i stand til å bringe tilveie fullstendinge og ufalskbare fullmakter uten noen gang å ha vært i kontakt med hjemmedomenet.
* Siden den mobile nodes fullmakter må holdes ufalskbare må ikke mellomliggende noder være i stand til å lære noe som setter dem i stand til å rekonstruere og gjenbruke fullmakter.
* En betjeningsnode må kunne håndtere forespørsler fra mange klienter samtidig.
* Betjeningsnoden må være beskyttet mot replay attacks.
* Digitale sertifikater bør kunne fraktes i en AAA-melding, og AAA-infrastruktur bør også kunne assistere med hensyn på validering av fullmakter, slik at fremmedagenten og hjemmeagenten blir avlastet.
* Støtte for regnskapsføring.
* Krav relatert til IP-operasjon:
  * Enhver AAA-tjener må være i stand til å tilordne passende IP-adresser på forespørsel fra klient.
  * AAA-tjener må være i stand til å identifisere klienten også ved hjelp av andre hjelpemidler enn IP-adresse.
* Mobil IP(v4):
  * Betjeningsnode = Fremmedagent.
  * AAAH og HA trenger ikke tilhøre samme domene, eksempelvis kan AAAH-tjeneren tilhøre et spesialdomene for et kredittkortfirma.
  * For mobil IP får AAAH og AAAL følgende tilleggsoppgaver:
    * Reautentisering av mobile enheter
    * Autorisasjon av mobil node
    * Initiering av regnskapsfunksjoner for å registrere bruk av tjenester
    * Bruk av AAA-protokoll extensions for å inkludere Mobile IP registreringsmelding som del av den første registreringssekvens.

((Se nærmere på IPv6, s 144 ->))

### Radius



Be able to describe what a Meta Protocol is and how the use of such protocols are intended (with reference to ETSIs TIPHON standards and consecutive standards). 
----------------------------------------------------------------------------------------------------------------------------------------------------------------

* Metaprotokoll: Et domeneuavhengig protokollrammeverk. En metaprotokoll beskriver meldinger som skal sendes, deres informasjonsinnhold og oppførselen til systemene — når meldinger skal sendes og når de skal mottas. En slik metaprotokoll er ikke designet for realisering direkte, men tjener som en referanse for andre protokoller. Realiseringer vil da lett kunne samarbeide, siden de er bygd på samme metaprotokoll.
* Det er ikke alltid mulig å anvende en metaprotokoll for å generere en fullstending avbildning over til en gitt protokoll. Dette resulterer i at man må 
definere utvidelser til den eksisterende metaprotokollen eller mangler ved den valgte protokoll.
* Metaprotokollen kan bli implementert fullstending i den hensikt å utvikle applikasjonstjenere, eller den kan bli brukt som et verktøy for å utvide eksisterende protokoller og sørge for samvirke mellom dem.
* TIPHON-metaprotokollen definerer en funksjonalitet på applikasjonslagesnivå som omfatter en mengde applikasjoner som anses som nøvendige i neste generasjons telefoni. Metaprotokollen består av tilstandsmaskiner som kan utføre anropsbehandling/sesjonsstyring.
* Grunnlaget for metaprotokollen er den abstrakte arkitekturen i TISPAN, som definerer funksjonelle lag, referansepunkt og grensesnitt mellom funksjonelle lag. Et funksjonelt lag utfører spesielle sett av oppgaver.

![Samvirke definert ved hjelp av metaprotokoll](meta-protocol.png)

Be able to give a review on problems concerning interworking between traditional and IP-based telecommunication networks. 
-------------------------------------------------------------------------------------------------------------------------

Hovedproblemstillingen er samdrift mellom et IP-nett og SCN. Men også mange andre problemstillinger. Blant annet ønsker man å beskytte tidligere investeringer, og kunne ha en gradvis eller trinnvis overgang fra GSM til UMTS, og en gradvis overgang fra en infrastruktur basert på linjesvitsjing til en infrastruktur basert på pakkesvitsjing. 

To former for samdrift:
* Samdrift av styringssystem, altså samvirke mellom IN-basert styringslogikk og internettbaserte styringssystemer.
* Samdrift av styringssystem og samband, altså sammenkobling av IP-baserte og CS-baserte samtaleveier.

### Samdrift av styringssystem

* IETF tok opp problemet med samvirke mellom IN-tjenester i det offentlige telefonnetter (PSTN) og IP-nettet i arbeidsgruppen PINT (PSTN/Internet Interfaces).
* PINT adresser "anrop" eller initiering fra internettsiden mot PSTN. Formålet er i hovedsak å kunne tilby telefontjenester initiert ved klikk på en webside.
* Fokus:
  * Klikk for å ringe opp
  * Klikk for å fakse
  * Klikk for å få faks tilbake
  * Taletilgang til webtjenester
* Arbeid videreført i SPIRITS (Service in the PSTN/IN Requesting Internet Service), som ser på initiering fra PSTN mot internett.
* Komplekst system. Startet derfor med arbeidet med å få til en full samdrift mellom IP-telefoni og PSTN. => Gateways.

### Samdrift av styringssystem og samband

* Neste generasjons nett (NGN) er forutsatt å være et IP-basert tjenesteintegrert nett, med mekanismer for differensiert styring av tjenestekvalitet.
* 5 scenarier for samvirke:
  1. IP-nett til IP-nett (ikke samvirke, ren NGN)
  2. IP-nett til CSN
  3. CSN til IP-nett
  4. CSN til CSN via IP-nett
  5. IP-nett til IP-nett via CSN
* For de scenarier en starter i ett type nett og ender i en annen må man
  * konvertere adresseformater (eks IP -> E.164).
  * konvertere mellom forskjellige signaleringsprotokoller/-systemer.
  * konvertere mellom forskjellige transportprotokoller (eks. linjesvitsjing til TCP/IP).
  * konvertere fra en type kildekoding til en annen.
* Må finne ut hvor eventuelle overgangsenheter (Interworking Function, IWF) er plassert.
* Ang scenariene:
  * (2) Det kan det rent økonomisk være lurt å gå over så sent som mulig, men eventuell dårlig tjenestekvalitet i nettet kan betinge en tidligere overgang.
  * (4,5) åpner for løsning der man oppretter en tunnet gjennom transittnettet. Dersom man skal tunnelere IP-telefoni gjennom PSTN/CSN må man passe på å sikre seg mot transkoding underveis, siden flere nett komprimerer talesignaler for å øke antall tilgjengelige samband på en strekning. Man må ha en ren digital, linjesvitsjet forbindelse.
  * (3) Hvordan oversette E.164-nummer til IP-adresser?
  * (3) Hvordan betjene nomadiske IP-brukere?
  * (4) IP-strekningen introduserer en økt og variabel tidsforsinkelse.
  * (2-5) Oppsetning av rene to-parts telefoniforbindelser kan løses relativt enkelt, men multimedie-sesjoner på tvers av CS- og PS-domenet kan by på større problemer.

![PINT referansemodell](pint-reference.png)

### IMS

It is desirable for the IMS to interwork with legacy CS networks. This requires interworking both at the user plane and the control plane. Control plane interworking is tasked to the MGCF, while the IMS-MGW translates protocols at the user plane.

(Fig 3.23 og 3.24, s 95 IMS)

Be able to account for the most employed addressing and number systems within communication
-------------------------------------------------------------------------------------------

### DNS

* The Domain Name System (DNS) is a hierarchical naming system for computers, services, or any resource participating in the Internet. 
* Translates domain names meaningful to humans into the numerical (binary) identifiers associated with networking equipment for the purpose of locating and addressing these devices world-wide.
* People take advantage of this when they recite meaningful URLs and e-mail addresses without having to know how the machine will actually locate them.
* The Domain Name System distributes the responsibility of assigning domain names and mapping those names to IP addresses by designating authoritative name servers for each domain. Authoritative name servers are assigned to be responsible for their particular domains, and in turn can assign other authoritative name servers for their sub-domains. This mechanism has made the DNS distributed, fault tolerant, and helped avoid the need for a single central register to be continually consulted and updated.
* The domain name space consists of a tree of domain names. Each node or leaf in the tree has zero or more resource records, which hold information associated with the domain name.
* A domain name usually consists of two or more parts (technically labels), which are conventionally written separated by dots.
* The Domain Name System is maintained by a distributed database system, which uses the client-server model. The nodes of this database are the name servers. Each domain or subdomain has one or more authoritative DNS servers that publish information about that domain and the name servers of any domains subordinate to it. The top of the hierarchy is served by the root nameservers.
* The client-side of the DNS is called a DNS resolver. It is responsible for initiating and sequencing the queries that ultimately lead to a full resolution (translation) of the resource sought.
* Resolving usually entails iterating through several name servers to find the needed information. However, some resolvers function simplistically and can communicate only with a single name server. These simple resolvers rely on a recursive query to a recursive name server to perform the work of finding information for them.
* Grunnene til å ikke ha et sentralisert DNS inkluderer: single point of failure, for stort trafikkvolum for én tjener, fjerntliggende sentralisert database, ikke skalerbar.
* Alle vertsmaskiner må ha minst en autorativ navnetjener.
* Because of the huge volume of requests generated by a system like DNS, the designers wished to provide a mechanism to reduce the load on individual DNS servers. To this end, the DNS resolution process allows for caching.

![Iterativt DNS-oppslag](dns-lookup.png)

### IPv6

A subnetwork, or subnet, describes networked computers and devices that have a common, designated IP address routing prefix. Subnetting is used to break the network into smaller more efficient subnets to prevent excessive rates of Ethernet packet collision in a large network. All hosts within a subnet can be reached in one "hop" (time to live = 1), implying that all hosts in a subnet are connected to the same link. A typical subnet is a physical network served by one router.

* Adressefelt på 128 bit
* Tre typer adresser:
  * Unikast. Identifiserer et enkelt grensesnitt, og pakker med en unikast-adresse blir levert til denne adressen. Kan kalles *gitt mottaker*.
  * Anykast. Identifiserer et sett med grensesnitt, vanligvis tilhørende forskjellige noder i nettet. Pakker med anykast-adresse skal leveres til *én* av de aktuelle grensesnittene. An anycast address is a single address assigned to multiple nodes. Delivers to the "nearest" one, according to the routing protocols' measure of distance.
  * Multikast. Identifiserer et sett med grensesnitt, vanligvis tilhørende forskjellige noder i nettet. Pakker med multikast-adresse skal leveres til *alle* aktuelle grensesnitt. Et gitt grensesnitt kan være medlem av et virkårlig antall multikast-grupper. 
* I IPv6 blir adressene tilordnet grensesnitt, ikke noder. 
* Addresses are assigned to interfaces, and a single network host or node can have multiple interfaces, or a single interface with multiple addresses.

![Adressetyper i IPv6](ipv6-address-types.png)

#### Uspesifisert

Must never be assigned to an interface and is to be used only in software before the application has learned its host's source address appropriate for a pending connection.

#### Loopback

Kan anvendes for å sende IP-pakker til seg selv. Skal normalt ikke nå fysisk nettgrensesnitt. Corresponding to 127.0.0.1 in IPv4.

#### Linklokal unikast

Skal aldri bli videresendt til en annen link. Link-Local addresses are designed to be used for addressing on a single link for purposes such as automatic address configuration, neighbor discovery, or when no routers are present. All interfaces are required to have at least one Link-Local unicast address.

<pre>
| 10 bits  |         54 bits         |          64 bits           |
+----------+-------------------------+----------------------------+
|1111111010|           0             |       interface ID         |
+----------+-------------------------+----------------------------+
</pre>

#### Global unikast

Conventional, publicly routable address, just like conventional IPv4 publicly routable addresses. => Alt annet enn det som er spesifisert i tabellen. Anycast addresses are taken from the unicast address spaces.

<pre>
|         n bits         |   m bits  |       128-n-m bits         |
+------------------------+-----------+----------------------------+
| global routing prefix  | subnet ID |       interface ID         |
+------------------------+-----------+----------------------------+
</pre>

#### Anykast

Anycast addresses are allocated from the unicast address space, using any of the defined unicast address formats.

#### Multikast

An IPv6 multicast address is an identifier for a group of interfaces (typically on different nodes).  An interface may belong to any number of multicast groups.
   
<pre>
|   8    |  4 |  4 |                  112 bits                   |
+------ -+----+----+---------------------------------------------+
|11111111|flgs|scop|                  group ID                   |
+--------+----+----+---------------------------------------------+
</pre>

De tre første bit i flags skal settes til 0, men det siste bit-et, T, indikerer om scope er transient. T = 0 indicates a permanently-assigned ("well-known") multicast address, assigned by the Internet Assigned Numbers Authority (IANA). T = 1 indicates a non-permanently-assigned ("transient" or "dynamically" assigned) multicast address.

scop is a 4-bit multicast scope value used to limit the scope of the multicast group.  The values are as follows:

<pre>
0  reserved
1  Interface-Local scope
2  Link-Local scope
3  reserved
4  Admin-Local scope
5  Site-Local scope
6  (unassigned)
7  (unassigned)
8  Organization-Local scope
9  (unassigned)
A  (unassigned)
B  (unassigned)
C  (unassigned)
D  (unassigned)
E  Global scope
F  reserved
</pre>

* Interface-Local scope spans only a single interface on a node and is useful only for loopback transmission of multicast.
* Link-Local multicast scope spans the same topological region as the corresponding unicast scope.
* Admin-Local scope is the smallest scope that must be administratively configured, i.e., not automatically derived from physical connectivity or other, non-multicast-related configuration.
* Site-Local scope is intended to span a single site.
* Organization-Local scope is intended to span multiple sites belonging to a single organization.
* scopes labeled "(unassigned)" are available for administrators to define additional multicast regions.

<pre>
All Nodes Addresses:    FF01:0:0:0:0:0:0:1 (interface-local)
                        FF02:0:0:0:0:0:0:1 (link-local)
All Routers Addresses:  FF01:0:0:0:0:0:0:2 (interface-local)
                        FF02:0:0:0:0:0:0:2 (link-local)
                        FF05:0:0:0:0:0:0:2 (site-local)
Solicited-Node Address: FF02:0:0:0:0:1:FFXX:XXXX
</pre>

Solicited-Node multicast address are computed as a function of a node's unicast and anycast addresses.  A Solicited-Node multicast address is formed by taking the low-order 24 bits of an address (unicast or anycast) and appending those bits to the prefix FF02:0:0:0:0:1:FF00::/104. Denne adresseformen brukes når en node skal "henge seg på" en eller flere multikastgrupper.

A host is required to recognize the following addresses as identifying itself:

* Its required Link-Local address for each interface.
* Any additional Unicast and Anycast addresses that have been configured for the node's interfaces (manually or automatically).
* The loopback address.
* The All-Nodes multicast addresses.
* The Solicited-Node multicast address for each of its unicast and
anycast addresses.
* Multicast addresses of all other groups to which the node
belongs.

A router is required to recognize all addresses that a host is required to recognize, plus the following addresses as identifying itself:

* The Subnet-Router Anycast addresses for all interfaces for which it is configured to act as a router.
* All other Anycast addresses with which the router has been configured.
* The All-Routers multicast addresses.

### Interface Identifiers

Interface identifiers in IPv6 unicast addresses are used to identify interfaces on a link. They are required to be unique within a subnet prefix.

* Links or Nodes with IEEE EUI-64 Identifiers: The only change needed to transform an IEEE EUI-64 identifier to an interface identifier is to invert the "u" (universal/local) bit.
* Links or Nodes with IEEE 802 48-bit MACs: Create an IEEE EUI-64 identifier from an IEEE 48-bit MAC identifier by inserting two octets, with hexadecimal values of 0xFF and 0xFE, in the middle of the 48-bit MAC (between the company_id and vendor-supplied id).

### Telefonnummer

### GSM og UMTS

* IMSI (International Mobile Subscriber Identity). Identifikator som brukes internt, blant annet til identifikasjon av mobilterminal i radiostyringssystemet for å kunne starte registrering i et besøksområde, fastlegge hjemmenettet til en besøkende mobilterminal/bruker, identifisere terminal/bruker når opplysninger angående tjenester for brukeren utveksles mellom nettene, og identifikasjon av terminal/bruker med hensyn på avregning. Mobil landkode (MCC, 3 siffer) + Nettoperatør (MNC, 2 eller 3 siffer) + Abonnentidentitet (MSIN) = max 15 siffer.
* TMSI (Temporary Mobile Subscriber Identity). Temporær identitet tilordnet av VLR eller SGSN (P-TMSI), som må kunne relateres til aktuell UEs eller MS' (mobile station) IMSI.
* TLLI (Temporary Logical Link Identity). Signalling address for communication between the MS (Mobile Station) and the SGSN. 
* MSISDN (Mobile Station International PSTN/ISDN Number). The standard international telephone number used to identify a given subscriber.
* MSRN (Mobile Station Roaming Number). Temporært anropsnummer som er tildelt MS på besøksplassen. MSISDN brukes til å finne HLR, der man får adgang til MSRN, slik at anropet kan rutes til besøkende MSC. 
* MSIDN (Mobile Station International Data Number). 
* Handover Number. Blir brukt til å etablere kobling mellom MSC-er i forbindelse med handover. Samme form som MSRN.
* IMEI (International Mobile Equipment Identifier). Unique identifier allocated to each ME (Mobile Equipment). It consists of a TAC (Type Approval Code, 8 siffers), SNR (Serial Number,  6 siffers) and a Spare Digit.
* LAI (Location Area Identification). Uniquely identifies a LA (Location Area) within any PLMN (Public Land Mobile Network). It is comprised of the MCC (Mobile Country Code, 3 digits), MNC (Mobile Network Code, 2 or 3 digits) and the LAC (Location Area Code, 2 octets).
* RAI (Routing Area Identity). Composed of the LAC (Location Area Code) and the RAC (Routing Area Code). It is used for paging and registration purposes.
* CI (Cell Identity) & CGI (Cell Group Identity). Under en gitt basestasjon kan man bruke en gitt celle. A 16bit identifier in GSM and UMTS. When combined with the LAI (Location Area Identity) or RAI (Routing Area Identity) the result is termed the CGI (Cell Global Identity).
* BSIC (Base Station Identity Code). For at en MS skal kunne holde rede på basestasjonene i nærheten, gis disse sin spesifikke identifikasjon. 

### Internett

* URI = Uniform Resource Identifier. Consists of a string of characters used to identify or name a resource on the Internet. Such identification enables interaction with representations of the resource over a network, typically the World Wide Web, using specific protocols. URIs are defined in schemes specifying a specific syntax and associated protocols.
* URL = Uniform Resource Locator. A type of URI that specifies where an identified resource is available and the mechanism for retrieving it.
* URN = Uniform Resource Name. A URI that uses the urn scheme, and does not imply availability of the identified resource.

A Uniform Resource Name (URN) functions like a person's name, while a Uniform Resource Locator (URL) resembles that person's street address. The URN defines an item's identity, while the URL provides a method for finding it.

NAI is a standard way of identifying users who request access to a network. Globalt navnerom for brukeridentiteter på formen <brukernavn>@<domenenavn>. Kan grovt si at NAI har samme funksjon i Internett som IMSI i UMTS/GSM.

I fremtidige IP-baserte Multimediakjernenett (IMCN) opererer man med tre typer IP-adresser eller identiteter:

1. Privat brukeridentitet. Tilordnes av hjemmeoperatøren og brukes for all håndtering av abonnement og regninger. Vil blant annet bli larget i HSS, og funnet av og mellomlagret i S-CSCF under registrering.
2. Offentlig brukeridentitet. Den gyldige "anropsidentiteten". Skal ha form som en SIP URL eller eventuelt foreligge i "tel:"-URL-formatet.
3. Temporær offentlig brukeridentitet. 

![Forhold mellom private og offentlige brukeridentiteter](nai-user-identities.png)

CSCF-, BGCF- og MGCF-noder skal kunne identifiseres ved hjelp av gyldige SIP URL-er over de grensesnitt som støtter SIP-protokollen.

Know what is meant by resource discovery and be familiar with some examples
---------------------------------------------------------------------------

Ressursavdekking er en funksjon som tillatter terminalen eller brukeren å oppdage eler kartlegge tilgjengelige ressurser. Ethvert system som gir støtte for flyttbare enheter bør/må ha implementert en eller annen metodikk for ressursavdekking, og etterfølgende konfigurering. 

To løsningsmåter:

* Ressursene annonserer sin tilstedeværelse ved kringkasting eller multicast på mediet (med jevne mellomrom).
* Ved å etterspørre ressursene. Enklest kan dette gjøres når ressursene har fått "velkjente" adresser som kan benyttes for å nå dem.

### Neighbour discovery, IPv6

* Nodes (hosts and routers) use Neighbor Discovery to determine the link-layer addresses for neighbors known to reside on attached links and to quickly purge cached values that become invalid.  Hosts also use Neighbor Discovery to find neighboring routers that are willing to forward packets on their behalf.  Finally, nodes use the protocol to actively keep track of which neighbors are reachable and which are not, and to detect changed link-layer addresses.  When a router or the path to a router fails, a host actively searches for functioning alternates.
* Alle noder trenger å kjenne til minst én ruter, som kan formidle pakker til andre maskinter som ikke befinner seg på samme lokalnett.
* Funksjoner:
  * Avdekking av rutere tilknyttet samme link.
  * Avdekking av prefiks som spesifiserer mottakere på samme link.
  * Parameteravdekking, f.eks. MTU (maksimal overføringsenhet målt i oktetter) og grense for antall hopp.
  * Selvkonfigurering av adresse.
  * Linkadresseoppslag. Hvordan bestemme linklagsadresse til en mottaker på samme link når bare IP-adressen er kjent.
  * Bestemmelse av neste hopp.
  * Deteksjon av nabo som ikke kan nåes.
  * Deteksjon av adressedubletter.
  * Omdirigering.
* Meldingstyper:
  * Ruterforespørring. Når et grensesnitt blir aktivert kan en vertsmaskin sende en slik melding for å trigge øyeblikkelig ruterannonsering.
  * Ruterannonsering. Enten perodisk eller på forespørsel. 
  * Naboforespørring. Sendes ut for å få kjennskap til linklagsadressen til en nabo, for å verifisere at naboen fortsatt kan nåes ved hjelp av en cachet linklagsadresse, eller for å sjekke om det eksiterer adressedubletter.
  * Naboannonsering. 
  * Omruting.
* Naboavdekkingsprotokollen har egentlig Ethernet, linklaget, som hovedreferanse. En linklagsadresse er i den sammenhegn en IEEE 802-basert MAC-adresse. Naboavdekking foregår på samme link.
* De fleste meldingene vil bli sendt med en MAC-adresse
* Linklag:
  * Multikast. A link that supports a native mechanism at the link layer for sending packets to all or a subset of all neighbors.
  * Punkt-til-punkt. A link that connects exactly two interfaces. A point-to-point link is assumed to have multicast capability and have a link-local address.
  * Multiaksess. A link to which more than two interfaces can attach, but that does not support a native form of multicast or broadcast.
* Hop Limit = 255. Slik kan vi sikre oss mot at pakken er videresendt av en ruter, siden ruteren dekrementerer verdien med 1 for hver videresending.

#### RDF

(s. 131 ->)

Be able to account for network and conceptual architecture for next generation networks (TISPAN/NGN-ETSI and IMS) 
-----------------------------------------------------------------------------------------------------------------

* Målet med TISPAN er å komme fram til en generisk NGN-regeransemodell som omfatter sammensmeltingen av fast-nett, mobilnett og interenett-teknologi. En generisk referansemodell definerer en referansearkitektur som er teknologiuavhengig.
* To fremtidige utviklingsscenarier:
  1. Internett-scenarioet
  2. Teleoperatørscenarioet

Be able to describe the VoIP architecture: SIP (SIP proper)
-----------------------------------------------------------

* Session Initiation Protocol (SIP) er designet for å sette opp sesjoner i Internett.
* SIP brukes primært for styring (signalering) av selve oppsettet, men kan også benyttes for å gjøre endringer i sesjonen mens den pågår.
* Anvendelsområder:
  * Lokalisering av bruker (Aksessnettet hvor brukeren befinner seg)
  * Brukertilgjengelighet
  * Brukerprofil
  * Oppsetting av sesjon
  * Sesjonsadministrasjon
* SIP beskriver selve arkitekturen for signaleringssystemet, men Session Description Protocol (SDP) benyttes for å beskrive innhold i signaleringsmeldingene. SIP frakter altså ikke mediainnhold mellom brukere, men er en signaleringsprotokoll.
* Artikekturen består i hovedsak av fire typer identiteter:
  * SIP brukeragent.
  * SIP proxy-tjener.
  * DNS.
  * Lokasjonstjener.
* Abonnenten får tildelt en identitet, i form av en SIP Uniform Resource Indicator (URI), som har samme form som en email-adresse.
* Alt utstyr som kan bruke IP/UDP kan være SIP brukeragent.
* Registreringsfunksjonen i SIP kan være lagt til en proxy-tjener. Dersom den legges til egen tjener kalles denne Registrar. En registrar vil normalt skrive resultatet av registreringen i en location server, og virker som en slags HLR i GSM.
* SIP is a permanent element of the IP Multimedia Subsystem (IMS) architecture for IP-based streaming multimedia services in cellular systems.

![Nett-elementer som inngår i SIP](sip-entities.png)

SIP: Be able to describe the following concepts and their function: Proxy, Redirect Server, Registrar, User Client, SDP
-----------------------------------------------------------------------------------------------------------------------

Be able to describe how SIP is intended integrated in 3GPP/UMTS
---------------------------------------------------------------

* 3GPP-konsortiet baserer seg på SIP for oppsetting.
* I 3GPP benyttes SIP som utgangspunkt for å håndtere multimedieanrop.
* CSCF = Call Session Control Function (sesjonskontroll)
* User Equipment (UE) er en SIP brukeragent som betjenes av Proxy-CSCF (P-CSCF), som igjen kommuniserer med Serving-CSCF (S-CSCF). I 3GPP er det S-CSCF som styrer og vedlikeholder et tilstandsbilde for sesjonen. Dette skjer altså i hjemmenettet til abonnenten.
* P-CSCF
  * Er UEs første kontaktpunkt. 
  * Fungerer som en vanlig proxy, og kan videresende forespørsler på vegne av en bruker. 
  * Skal kunne generere CDR-er, vedlikeholde sikker kommunikasjon mellom seg og UE, utføre meldingskompresjon og -dekompresjon, samt å ta seg av autorisering av bærer-ressurser og QoS-administrasjon.
* Interrogating-CSCF (I-CSCF)
  * Kontaktpunkt mot en operatørs nett for alle forbindelser som ankommer til brukere hos denne operatøren, og til gjestebrukere som oppholder seg i området. 
  * En operatør kan ha flere I-CSCF-er. Er en slags grensevakt. 
  * Finner adressen til S-CSCF ved hjelp av Home Subscriber Server (HSS). 
  * Tilordner S-CSCF til en bruker som utfører SIP-registrering. 
  * Ruter SIP-forespørsler mottatt fra andre nett til egnet S-CSCF i eget nett. 
  * Genererer CDR-er.
  * Nettoperatør trenger ikke benytte seg av I-CSCF, men fordelen er at man kan gjemme vekk opplysninger om den indre strukturen i nettet.
* S-CSCF
  * Betjener bruker under sesjonen.
  * The brain of the IMS.
  * Located in the user’s home network
  * Utfører styring av sesjonen på vegne av UE.
  * The S-CSCF performs session control and registration services for the UE. During the session, the S-CSCF maintains the session state and interacts with the service platforms and charging functions as required by the network operator to provide the services. There can be a number of S-CSCFs in an operator’s network and the S-CSCFs can provide a variety of unique functions depending on the nature of the application service platforms. In essence the S-CSCF marries the capabilities of the UE with the services of the application servers.
  * Funksjoner:
    * Handle registration requests
    * Authenticate users
    * Download information from the HSS
    * Route traffic to P-CSCF/I-CSCF/BGCF/AS as needed: The S-CSCF routes mobile-terminating traffic to the P-CSCF. It also routes mobile-originated traffic to the I-CSCF, the breakout gateway control function (BGCF), or the application server (AS).
    * Perform session control: Act as a SIP proxy server and/or user agent
    * Supervise registration
    * Execute media policing
    * Maintain session timers
    * Generere CDR-er
* Breakout Gateway Control Function (BGCF)
  * To move from the IMS to the circuit-switched domain, the IMS uses the breakout gateway control function (BGCF), which determines where the breakout to the circuit-switched domain occurs. 
  * Tilordner Media Gateway Control Function (MGCF) som vil være ansvarlig for samvirke med PSTN/CS Domain.
  * Velger hensiktsmessig sted for overgang til PSTN/CS Domain.
* Basissesjoner mellom to mobile brukere vil alltid benytte to S-CSCF-er.
* En basissesjon mellom en bruker i UMTS-multimedienett og et punkt i PSTN involverer én S-CSCF for UE-en, én BGCF for å velge PSTN-gateway, og én MGCF for styring av mediekonvertering via a vis PSTN.
* S-CSCF tilsvarer CCAF i IN, den er grensen mellom bruker og oppsetning i nettet.

![Omgivelser for SIP-basert tjenestestyring i UMPS IP-basert multimediakjernenett](sip-environment.png)

Be able to describe the underlying idea/purpose of PARLAY/OSA and how it is realized
------------------------------------------------------------------------------------

Be able to describe the philosophy behind/principles of “stateless network control” and why it is desirable to implement a service logic mainly based on this principle
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Vil man egentlig ha _kun_ et stupid network? Begge deler har sine positive og negative sider. Reliability, Accounting og QoS er fortsatt bedre i intelligente nett, mens det er mye raskere å innføre nye tjenester i dumme nettverk, samt at ...

Know what a Media Gateway and a Media Gateway Controller is/does
----------------------------------------------------------------

Noen ikke-plasserte notater
---------------------------

* Et fremtidig heterogent nett vil få et omfattende behov for overganger (gateways) for overføring av både styresignaler og "nyttesignaler" mellom forskjelllige deler av nettet.
* Mål for framtidig tjenesteutvikling er å etablere et fleksiblet verktøysett av "tjenestemoduler" som kan instansieres/plugges inn i nettverket etter behov. Dette setter store krav til spesifisering og standardisering.