package com.example.indooraou

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Polygon

object Constants {
    val aouLatLng = LatLng(23.591071173276454, 58.457004535518706)
    const val TAG = "DEBUG_MATE"
    const val MAPVIEW_BUNDLE_KEY = "MapViewBundleKey"
    val aouBuildingPoints = listOf(
        LatLng(23.590894992200358, 58.45675429090943),
        LatLng(23.590871954553382, 58.45679464385225),
        LatLng(23.590794480873242, 58.45675659398233),
        LatLng(23.59079713400618, 58.45683235392209),
        LatLng(23.59081657525502, 58.456835350393966),
        LatLng(23.59080011817836, 58.45688803850345),
        LatLng(23.590816802265536, 58.45690304895584),
        LatLng(23.590812676176025, 58.45690753309606),
        LatLng(23.59080053841724, 58.45697185421445),
        LatLng(23.591284393230453, 58.457256729087085),
        LatLng(23.591315088517444, 58.45720216440337),
        LatLng(23.591343055366178, 58.45721750330867),
        LatLng(23.59139470107558, 58.45712295664332),
        LatLng(23.591348472905736, 58.457073971095866),
        LatLng(23.591368385304886, 58.45704313982411)
    )
    val aouBuildingInnerParkingPoints = listOf(
        LatLng(23.59080164830448,58.456970863044255),
        LatLng(23.59079212336528,58.457206226885326),
        LatLng(23.591218286903555,58.45746774226427),
        LatLng(23.591344875950348,58.45721829682588),
        LatLng(23.591317223013647,58.45719985663891),
        LatLng(23.591283732226977,58.457253836095326)
    )
    val aouBuildingOuterParkingPoints = listOf(
        LatLng(23.59121982317912,58.45746506005525),
        LatLng(23.591182645305235,58.45755860209466),
        LatLng(23.59085326731776,58.457551561295986),
        LatLng(23.59080472086536,58.45754921436309),
        LatLng(23.590781369400844,58.45754452049733),
        LatLng(23.59076016872551,58.45752138644456),
        LatLng(23.59075064378331,58.457498252391815),
        LatLng(23.59073896804675,58.457481153309345),
        LatLng(23.59073374469059,58.45747411251069),
        LatLng(23.590726063284098,58.457453325390816),
        LatLng(23.590723297977647,58.45742918550969),
        LatLng(23.590719918158584,58.45741409808397),
        LatLng(23.59071561657055,58.45738861709833),
        LatLng(23.590713773032775,58.45736581832171),
        LatLng(23.59071131498236,58.45734503120184),
        LatLng(23.590712544007566,58.45729876309633),
        LatLng(23.59071561657055,58.45726389437913),
        LatLng(23.59071561657055,58.457239754498),
        LatLng(23.59079212336528,58.45720488578082),
    )
    val groundFloorPoints = listOf(
        //reception
        listOf(
            LatLng(23.590870780906933, 58.45701109617948),
            LatLng(23.59090672984583, 58.45694739371539),
            LatLng(23.590966030210662, 58.456975892186165),
            LatLng(23.590937455426804, 58.45705132931471)
        ),
        listOf(
            //general lab
            LatLng(23.590921785381404, 58.456885032355785),
            LatLng(23.59095312547034, 58.456822000443935),
            LatLng(23.591073262408564, 58.45689307898284),
            LatLng(23.591054519824414, 58.45696918666363)
        ),
        listOf(
            //library
            LatLng(23.590922399893024, 58.45688469707966),
            LatLng(23.590939298961434, 58.456851840019226),
            LatLng(23.590993068710084, 58.456885367631905),
            LatLng(23.59097985671674, 58.456920571625226)
        ),
        listOf(
            //male prayer
            LatLng(23.59079519592639, 58.45675695687532),
            LatLng(23.59085695438936, 58.456786461174495),
            LatLng(23.59086217774061, 58.45682233572006),
            LatLng(23.590797346719118, 58.45679216086864)
        ),
        listOf(
            //hall
            LatLng(23.591110440313443, 58.45688436180354),
            LatLng(23.59108278732734, 58.45694102346898),
            LatLng(23.591198315319478, 58.45703020691872),
            LatLng(23.591230269852534, 58.456957451999195)
        ),
        listOf(
            //law building ground
            LatLng(23.591229962597442, 58.456957451999195),
            LatLng(23.591197393553983, 58.45702920109034),
            LatLng(23.591315993994105, 58.45711067318916),
            LatLng(23.591367612805033, 58.457042947411544)
        ),
        listOf(
            //financial
            LatLng(23.591099379119704, 58.45695208758115),
            LatLng(23.591064352000046, 58.45693297684193),
            LatLng(23.591054212568913, 58.45696784555913),
            LatLng(23.591098764608905, 58.456988632678986)
        ),

        listOf(
            //lounge
            LatLng(23.590951281935897, 58.45705803483725),
            LatLng(23.59098784536405, 58.45698527991772),
            LatLng(23.591032397426574, 58.45699299126864),
            LatLng(23.590997370289024, 58.4570825099945)
        ),

        listOf(
            //lounge
            LatLng(23.591032704682124, 58.45699165016413),
            LatLng(23.591106445993592, 58.45703724771738),
            LatLng(23.591078178495763, 58.45713213086128),
            LatLng(23.59099521949957, 58.45708418637515)
        ),

        )
    val groundPolygons = mutableListOf<Polygon>()
    val firstFloorPoints = listOf(
        //first floor hall
        listOf(
            LatLng(23.59107910026209, 58.456903137266636),
            LatLng(23.59100290089032, 58.45708787441253),
            LatLng(23.591275129087723, 58.45724880695342),
            LatLng(23.59134917751775, 58.457071781158454)
        ),
        //toilet
        listOf(
            LatLng(23.591034855470955, 58.457012102007866),
            LatLng(23.591077256729427, 58.45703121274709),
            LatLng(23.59106312297812, 58.45707412809134),
            LatLng(23.59102164348182, 58.4570463001728)
        ),
        //english lab
        listOf(
            LatLng(23.591079407517526, 58.45702953636646),
            LatLng(23.591127953868295, 58.457049988210194),
            LatLng(23.59110798227047, 58.45709390938282),
            LatLng(23.59106312297812, 58.45707345753908)
        ),
        //english tutors office
        listOf(
            LatLng(23.591127953868295, 58.457048647105694),
            LatLng(23.591167589799586, 58.45707513391971),
            LatLng(23.59115284154749, 58.457113020122044),
            LatLng(23.59110798227047, 58.45709189772606)
        ),
        // room 211
        listOf(
            LatLng(23.59116697528912, 58.45707278698683),
            LatLng(23.591212449056208, 58.457098267972476),
            LatLng(23.591198622574634, 58.45713615417481),
            LatLng(23.591154377823816, 58.45711067318916)
        ),
        //room 208
        listOf(
            LatLng(23.591213678076723, 58.45709692686797),
            LatLng(23.591260995357747, 58.457127436995506),
            LatLng(23.591253006727076, 58.45716062933206),
            LatLng(23.59119985159529, 58.457135483622544)
        ),
        // room 203
        listOf(
            LatLng(23.591130719166213, 58.456935994327075),
            LatLng(23.591116585420675, 58.45696549862623),
            LatLng(23.591171276862358, 58.45700170844793),
            LatLng(23.59118694687795, 58.45696985721589)
        ),
        //law building canteen
        listOf(
            LatLng(23.591312614190304, 58.457008749246604),
            LatLng(23.591297558699576, 58.4570375829935),
            LatLng(23.591349484772564, 58.45707077533007),
            LatLng(23.591366076531184, 58.45704160630703)
        ),
    )
    val firstPolygons = mutableListOf<Polygon>()
    val secondFloorPoints = listOf(
        // room 303
        listOf(
            LatLng(23.590937762682586, 58.456808254122734),
            LatLng(23.590915025753397, 58.45686223357916),
            LatLng(23.590978013182685, 58.456900790333755),
            LatLng(23.591001364612197, 58.45684781670571)
        ),
        // unknown tutor
        listOf(
            LatLng(23.59089105979675, 58.45702014863492),
            LatLng(23.590928545009064, 58.456951081752784),
            LatLng(23.590997677544653, 58.456987626850605),
            LatLng(23.590967566489194, 58.457064740359776)
        ),
        //toilet
        listOf(
            LatLng(23.591047760203242, 58.45687497407197),
            LatLng(23.591028095848777, 58.45692727714777),
            LatLng(23.591090775968365, 58.45696248114109),
            LatLng(23.59111136207955, 58.45691319555045)
        ),
        // female prayer
        listOf(
            LatLng(23.591111669334907, 58.456913866102695),
            LatLng(23.59116728254435, 58.45694839954377),
            LatLng(23.59115560684488, 58.4569950029254),
            LatLng(23.59108954694671, 58.45696214586496)
        ),
        // room 302
        listOf(
            LatLng(23.59116697528912, 58.45694739371539),
            LatLng(23.59123088436271, 58.45698695629835),
            LatLng(23.59121306356647, 58.457027189433575),
            LatLng(23.59115499233435, 58.456993326544755)
        ),
        //some other lab
        listOf(
            LatLng(23.59122873357708, 58.45698729157447),
            LatLng(23.591282810462072, 58.45701947808266),
            LatLng(23.59126898398792, 58.457056023180485),
            LatLng(23.59121214180109, 58.45702651888133)
        )
    )
    val secondPolygons = mutableListOf<Polygon>()
    val thirdFloorPoints = listOf(
        // lab 3
        listOf(
            LatLng(23.590937762682586, 58.456808254122734),
            LatLng(23.590915025753397, 58.45686223357916),
            LatLng(23.590978013182685, 58.456900790333755),
            LatLng(23.591001364612197, 58.45684781670571)
        ),
        //lab 2
        listOf(
            LatLng(23.59102932487102, 58.456926606595516),
            LatLng(23.590977705927003, 58.45690011978149),
            LatLng(23.591000750100957, 58.456845469772816),
            LatLng(23.59104929648082, 58.45687463879585)
        ),
        //lab 1
        listOf(
            LatLng(23.591047760203242, 58.45687497407197),
            LatLng(23.591028095848777, 58.45692727714777),
            LatLng(23.591090775968365, 58.45696248114109),
            LatLng(23.59111136207955, 58.45691319555045)
        ),
        // third canteen
        listOf(
            LatLng(23.59086801560354, 58.457009084522724),
            LatLng(23.590904579054886, 58.456921242177486),
            LatLng(23.590982007506454, 58.4569638222456),
            LatLng(23.59095619802767, 58.45702450722456),
            LatLng(23.591000750100957, 58.45704663544894),
            LatLng(23.59098508006311, 58.457077480852604)
        ),
        //it office
        listOf(
            LatLng(23.591046223925666, 58.45701679587364),
            LatLng(23.591012118558613, 58.4570949152112),
            LatLng(23.59107418417492, 58.45712844282389),
            LatLng(23.59110521697207, 58.457060381770134)
        ),
        // room 303
        listOf(
            LatLng(23.591159908418486, 58.45694538205862),
            LatLng(23.59114546742081, 58.456986285746105),
            LatLng(23.59121214180109, 58.457027189433575),
            LatLng(23.591229348087268, 58.45698695629835)
        )
    )
    val thirdPolygons = mutableListOf<Polygon>()

    // static location data within the building
    // pretend we have these data already populated in the database
    val groundFloor = listOf(
        Spot(
            "Entrance",
            "University entry point",
            LatLng(23.591015805625737,58.45732491463423),
            R.drawable.ic_marker,
        ),
        Spot(
            "Inner parking",
            "University inner parking",
            LatLng(23.59102901761546,58.457221984863274),
            R.drawable.ic_marker,
        ),
        Spot(
            "Outer parking",
            "University outer parking",
            LatLng(23.590824692509344,58.457450307905674),
            R.drawable.ic_marker,
        ),
        Spot(
            "Reception",
            "Reception",
            LatLng(23.59090269919594, 58.45699947880633),
            R.drawable.ic_address_book,
        ),
        Spot(
            "Lab",
            "University's General Lab",
            LatLng(23.590985167663927, 58.45687596418828),
            R.drawable.ic_globe
        ),
        Spot(
            "Library",
            "University's Library",
            LatLng(23.590949865798912, 58.45689647071755),
            R.drawable.ic_book
        ),
        Spot(
            "Lounge",
            "Reception lounge",
            LatLng(23.590983535010558, 58.45703384780652),
            R.drawable.ic_users
        ),
        Spot(
            "Registration",
            "Registration and admission center",
            LatLng(23.591022872504126, 58.457077816128724),
            R.drawable.ic_address_book
        ),
        Spot(
            "Financial",
            "Financial office",
            LatLng(23.591079639280256, 58.45696746308928),
            R.drawable.ic_edit
        ),
        Spot(
            "Elevator",
            "Elevator",
            LatLng(23.591271861462413, 58.457107946929305),
            R.drawable.ic_marker
        ),
        Spot(
            "prayer room",
            "Male prayer room",
            LatLng(23.590822234461015, 58.456787802278996),
            R.drawable.ic_heart
        ),
        Spot(
            "Hall",
            "University grand hall",
            LatLng(23.59114485291023, 58.45695074647665),
            R.drawable.ic_hall
        ),
        Spot(
            "Law building",
            "Law's students building",
            LatLng(23.591279123402444, 58.45703087747097),
            R.drawable.ic_law
        )
    )
    val firstFloor = listOf(
        Spot(
            "lab",
            "English lab",
            LatLng(23.591089668373762, 58.45706224739535),
            R.drawable.ic_e_learning
        ),
        Spot(
            "203",
            "Room 203",
            LatLng(23.591136430348033, 58.456960169113465),
            R.drawable.ic_book
        ),
        Spot(
            "Toilet",
            "Male restroom",
            LatLng(23.591046838436704, 58.457037918269634),
            R.drawable.ic_portrait
        ),
        Spot(
            "English tutors",
            "English tutors office",
            LatLng(23.591140551336125, 58.45708116889),
            R.drawable.ic_users
        ),
        Spot(
            "211",
            "Room 211",
            LatLng(23.59118786864352, 58.45710396766662),
            R.drawable.ic_book
        ),
        Spot(
            "208",
            "Room 208",
            LatLng(23.591238565739655, 58.45714017748833),
            R.drawable.ic_book
        ),
        Spot(
            "canteen",
            "Law building canteen",
            LatLng(23.591342725166594, 58.45704026520253),
            R.drawable.ic_food
        )

    )
    val secondFloor = listOf(
        Spot(
            "lab",
            "Some other lab",
            LatLng(23.591241023780174, 58.457014784216874),
            R.drawable.ic_e_learning
        ),
        Spot(
            "303",
            "Room 303",
            LatLng( 23.590959577840653, 58.45685150474309),
            R.drawable.ic_book
        ),
        Spot(
            "Toilet",
            "Female restroom",
            LatLng(23.591041305958, 58.45692134432408),
            R.drawable.ic_portrait
        ),
        Spot(
            "Prayer room",
            "Female Prayer room",
            LatLng(23.591131640932176, 58.45695946365594),
            R.drawable.ic_users
        ),
        Spot(
            "302",
            "Room 302",
            LatLng(23.591185717857194, 58.456986621022224),
            R.drawable.ic_book
        ),
        Spot(
            "Unknown tutor",
            "🤔",
            LatLng(23.590932232078554, 58.45700036734343),
            R.drawable.ic_book
        )

    )
    val thirdFloor = listOf(
        Spot(
            "Lab 1",
            "IT Lab 1",
            LatLng(23.591077871240316, 58.45692090690136),
            R.drawable.ic_e_learning
        ),
        Spot(
            "Lab 2",
            "IT Lab 2",
            LatLng(23.59102072171509, 58.456888385117054),
            R.drawable.ic_e_learning
        ),
        Spot(
            "Lab 3",
            "IT Lab 3",
            LatLng(23.59095558351621, 58.45685150474309),
            R.drawable.ic_e_learning
        ),
        Spot(
            "IT Office",
            "IT tutors Office",
            LatLng(23.591056670612893, 58.45705769956111),
            R.drawable.ic_users
        ),
        Spot(
            "Room 333",
            "Room 302",
            LatLng(23.5911718913728, 58.45697958022356),
            R.drawable.ic_book
        ),
        Spot(
            "Canteen",
            "Third floor canteen",
            LatLng(23.59091103142759, 58.456977233290665),
            R.drawable.ic_food
        )

    )
    const val MAIN_BUILDING_FILL_COLOR = "#5BF63333"
    const val MAIN_BUILDING_INNER_FILL_COLOR = "#5BF68733"
    const val MAIN_BUILDING_OUTER_FILL_COLOR = "#5BF6DC33"
}