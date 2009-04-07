Sammendrag av TTM4130 - Tjenesteintelligens og mobilitet
========================================================

Sammendraget er basert på læringsmålene i faget, og tar utgangspunkt i fagets kompendium og forelesningsfoiler, samt delvis ekstramaterialet spesifisert i læringsmålene.

(Deler av stoffet er kopiert fra ekstrematerialet, Wikipedia, eller andre kilder, og det er derfor mye blanding av norsk og engelsk i dette dokumentet.)

Know the difference between access network, transport network and service platform/IN
-------------------------------------------------------------------------------------

* Et moderne kommunikasjonssystem består av et aksessnett og et kjernenett, der kjernenettet gjerne deles i to nivåer, tjenesteplattform og transportnett.
* I transportnettet formidles nytteinformasjon, "budskapet", mellom deltagerne.
* Tjenesteplattformen blir anvednt for oppsetning, styring og kontroll av transportstrømmene.
* Utviklingen av tjenesteplattformen har kulminert i IN, som standardiserer funksjoner i tjenestestyringslaget.
* An access network is that part of a communications network which connects subscribers to their immediate service provider. 
* Det eksisterer to hovedutgaver av tjenesterealiseringsnett i Europa:
  * Intelligent Networks.
  * GSM-tjenesteplattform.
* Både IN- og GSM-rammeverket er uenget når mobile brukere ønsker integrering av webbaserte tjenester med vanlig telefoni, med fokus på multimedia-innhold.

Be familiar with modeling of a normal telephone calls states, and how to illustrate this by state descriptions and sequence diagrams
------------------------------------------------------------------------------------------------------------------------------------

Vanskelig å få tilgang til terminaltilstanden til en telefon direkte, og overvåker derfor samtaletilstanden:

* SBCP (Subscriber Basic Call Process)
* TBCP (Transit Basic Call Process)

Realiseres i form av tilstandsmaskiner. Hver enkelt abonnentlinje må ha sin egen tilstandsmaskin.

Minst tre forskjellige nivåer av informasjon:

* Nettets driftstilstand, inklusive den enkelte komponent
* Rutingtabeller
* Den enkelte forbindelse eller oppkobling

Be familiar with the Intelligent Network architecture
-----------------------------------------------------

* The term Intelligent Networks (IN) is used to describe an architectural concept which is intended to be applicable to all telecommunications networks and aims to ease the introduction and management of new services.
* With IN technology it is possible to introduce new services rapidly without affecting the available services. IN defines a large set of standards that describe the interfaces between different network control points. With only specifying the interfaces IN makes it possible for vendor systems to provide with different products and, of course, for operators to use any of these products in their network configuration.
* The Intelligent Network is a network architecture intended both for fixed as well as mobile telecom networks. It allows operators to differentiate themselves by providing value-added services in addition to the standard telecom services such as PSTN, ISDN and GSM services on mobile phones.
* In IN, the intelligence is provided by network nodes owned by telecom operators, as opposed to solutions based on intelligence in the telephone equipment, or in Internet servers provided by any part.
* IN is based on the Signaling System #7 (SS7) protocol between telephone network switching centers and other network nodes owned by network operators.
* The main concepts (functional view) surrounding IN services or architecture are connected with SS7 architecture.
* IN er et distribuert system for tjenestestyring.
* The standards define a complete architecture including the architectural view, state machines, physical implementation and protocols. 
* Before IN was developed, all new feature and/or services that were to be added had to be implemented directly in the core switch systems. This made for very long release cycles as the bug hunting and testing had to be extensive and thorough to prevent the network from failing. With the advent of IN, most of these services were moved out of the core switch systems and into self serving nodes (IN), thus creating a modular and more secure network that allowed the services providers themselves to develop variations and value-added services to their network without submitting a request to the core switch manufacturer and wait for the long development process.
* IN kan grovt sett sees som en tjenesteplattform som "utvider" transportnettet.
* Konseptuell modell i fire nivåer/plan. Each plane introduces an abstract view of the network entities, which is further made tangible in the plane below it. Tolkes top/down:
  1. Service plane. Abstrakt spesifikasjonslag. Tjenester beskrives ved hjelp av generelle blokker kalt Service Features. En tjeneste er et selvstendig kommersielt tilbud, og en tjenesteegenskap (service feature) beskriver et spesielt aspekt ved en tjeneste. Tjeneste og funksjoner realiseres ved hjelp av funksjoner fra nest øverste plan, såkalte Service Independent Blocks (SIB).
  2. Global functional plane. Delt i to deler. 
    * Global tjenestelogikk som styrer instanser av SIB-er. Samlingen av disse representerer et bibliotek som kan anvendes til å realisere tjenester. Tjenestelogikken spesifiserer hvordan et utvalg av slik funksjonalitet skal manøvreres for å skape en tjeneste. The SIBs are reusable components that can be chained together to construct a service logic. En enkelt SIB er en prosess som kan motta data, deretter prosessere denne, for så å overlevere til neste trini i kjeden.
    * ... Basic Call Processing (BCP) er et særtilfelle av en SIB. Utførelsen av en tjeneste starter og ender i BCP.
  3. Distributed functional plane. Inneholder en beskrivelse av hvordan SIB-funksjonalitet skapes ved hjelp av Functional Entities (FE). FE-kan distribueres i nettet, men én enkelt FE kan ikke distribueres. Altså kan FE-ene til én SIB være distribuert. Hver FE må utføre en Functional Entity Action (FEA), som er realisert ved hjelp av Elementary Functions (EF). Informasjonsflyten mellom flere FE-er går via FEA-ene. SIBs are realized by a sequence of FEAs in an FE. For at en gruppe funksjonelle enheter skal kunne realisere en SIB må de ha de nødvendige egenskaper og kunne samarbeide.
  4. Physical plane. Protokoller og prosessering som beskriver fordelingen av fysiske enheter i nettet. The FEs of the distributed functional plane are mapped to Physical Entities (PE). PEs communicate with each other by exchanging protocol messages (represented by information flows in the distributed functional plane). Describes the physical architecture alternatives for an IN-structured network in terms of potential physical systems, referred to as physical entities (PE), in a network, and interfaces between these PEs. The physical plane architecture describes how functional architecture map into Physical Entities and interfaces.
* The IN’s main advantage is the ability to control switching and service execution from a small set of Intelligent Network nodes known as Service Control Points (SCP). SCPs are connected to the network switches (known as Service Switching Points (SSP)) via a standardized interface; Signalling System No. 7.
* The SSPs detect when the SCP should handle a service. The SSP forwards a standardized SS7 (TCAP) message containing relevant service information. Via the TCAP message, the service control logic in the SCP directs the SSPs to perform the individual functions that collectively constitute the service.
* An Intelligent Network is able to separate the specification, creation, and control of telephony services from physical switching networks.

An IN-compliant service is first constructed through an FE called the Service Creation Environment Function (SCEF). This FE contains the programming environment, which includes the SIB that a programmer uses to construct an IN-compliant service. Once the service logic is created and tested, it is sent to another FE, the service management function (SMF). This FE deploys the service logic to the service execution FEs and allows for service customization. 

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

### Signal Transfer Point

* Enhet/ruter for signaleringstrafikk. Fordeler signaleringstrafikken mot SCP på en hensiktsmessig måte.

### Adjunct (AD)

* Samme funksjonalitet som SCP, men betjener bare én sentral. Har ofte egen SDP, og er som oftest samlokalisert med en trafikksterk sentral.

### Network Access Point (NAP)

* Sentral uten IN-funksjoner.
* Må benytte seg av SSP-utstyr i andre sentraler for å få tilknytning.

### Service Node (SN)

* Separat sammensatt node med en rekke funksjoner, satt sammen for å dekke lokalt behov. Stort sett samme funksjonalitet som en SSP, men ikke tilknyttet en sentral, altså kan den ikke behandle "normale" anrop.

Know what Signalling System No 7 is and how it is used
------------------------------------------------------

* To typer signalering:
  1. Channel Associated Signaling. With CAS signaling, this routing information is encoded and transmitted in the same channel as the payload itself.
  2. Common Channel Signaling. With CCS signaling information (control information) is transmitted on a separate channel to the data, and, more specifically, where that signaling channel controls multiple data channels.
* SS7 er et felleskanalsystem (CCS)
* Signaling System Number 7 (SS7) is a set of telephony signaling protocols which are used to set up most of the world's public switched telephone network telephone calls. 
* The main purpose is to set up and tear down telephone calls. Other uses include number translation, prepaid billing mechanisms, short message service (SMS), and a variety of other mass market services.
* SS7 skaper språket og kommunikasjonssystemet for å overføre meldinger, men det trengs enheter i nettet som tolker disse meldingene og reagerer på hensiktsmessig måte.
* The term signalling, when used in telephony, refers to the exchange of control information associated with the establishment of a telephone call on a telecommunications circuit.
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

![Comparison of transport layers](comparison-transport-layer.png)

Know what TMN is and what it is used for
----------------------------------------

(Telecommunications Management Network? s21)

Know the meaning of Terminal Mobility, Person Mobility and Service Mobility. Describing mobility handling in the GSM- and IP-world included. 
--------------------------------------------------------------------------------------------------------------------------------------------

Be able to describe what AAA means and where these functions are used. To be able to give a simple explanation/characterization of the protocols Radius and Diameter 
--------------------------------------------------------------------------------------------------------------------------------------------------------------------

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

Be able to account for the most employed addressing and number systems within communication
-------------------------------------------------------------------------------------------

Know what is meant by resource discovery and be familiar with some examples
---------------------------------------------------------------------------

Be able to account for network and conceptual architecture for next generation networks (TISPAN/NGN-ETSI and IMS) 
-----------------------------------------------------------------------------------------------------------------

* Målet med TISPAN er å komme fram til en generisk NGN-regeransemodell som omfatter sammensmeltingen av fast-nett, mobilnett og interenett-teknologi. En generisk referansemodell definerer en referansearkitektur som er teknologiuavhengig.
* To fremtidige utviklingsscenarier:
  1. Internett-scenarioet
  2. Teleoperatørscenarioet

Be able to describe the VoIP architecture: SIP (SIP proper)
-----------------------------------------------------------

SIP: Be able to describe the following concepts and their function: Proxy, Redirect Server, Registrar, User Client, SDP
-----------------------------------------------------------------------------------------------------------------------

Be able to describe how SIP is intended integrated in 3GPP/UMTS
---------------------------------------------------------------

Be able to describe the underlying idea/purpose of PARLAY/OSA and how it is realized
------------------------------------------------------------------------------------

Be able to describe the philosophy behind/principles of “stateless network control” and why it is desirable to implement a service logic mainly based on this principle
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

Know what a Media Gateway and a Media Gateway Controller is/does
----------------------------------------------------------------

Noen ikke-plasserte notater
---------------------------

* Et fremtidig heterogent nett vil få et omfattende behov for overganger (gateways) for overføring av både styresignaler og "nyttesignaler" mellom forskjelllige deler av nettet.
* Mål for framtidig tjenesteutvikling er å etablere et fleksiblet verktøysett av "tjenestemoduler" som kan instansieres/plugges inn i nettverket etter behov. Dette setter store krav til spesifisering og standardisering.