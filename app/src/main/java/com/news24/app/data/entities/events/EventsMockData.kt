package com.news24.app.data.entities.events

import com.news24.app.data.entities.events.model.*
import java.util.*

object EventsMockData {

    fun getItemsList(): List<Event> {
        return listOf(

			//region ===================== NEWS ======================
            Event(
                url = "https://sport24.ru/news/basketball/2022-04-15-uniks-podpisal-amerikanskogo-tsentrovogo-mosli",
                id = "n1",
                type = EventType.NEWS,
                publishDate = Date(1650044520),
                data = EventDataNews(
                    backgroundImage = "https://s74794.cdn.ngenix.net/api/v1/images/aa4e/256b/bc50/0e85/a78e/1379/4091/322f/1100_10000_max.jpeg", // TODO всегда
                    title = "УНИКС подписал американского центрового Мосли",
                    sport = "basketball",
                    tags = listOf(
                        EventTag(
                            "1",
                            "https://s74794.cdn.ngenix.net/m/e35c/fe1d/70d8/ddcd/9938/7def/39a6/8805/300_300_max.png"
                        ) // TODO 300_300_max.png
                    ),
                    image = "https://s74794.cdn.ngenix.net/m/0da4/62c7/8a5c/4c2b/a716/d147/7db6/42ba/1100_10000_max.jpeg",  // TODO 1100_10000_max.jpeg
                    content = listOf(
                        EventContent(
                            ContentType.PARAGRAPH,
                            "УНИКС на официальном сайте объявил о подписании американского центрового Уильяма Мосли."
                        ),
                        EventContent(
                            ContentType.PARAGRAPH,
                            "Соглашение между казанским клубом и 32-летним баскетболистом рассчитано до конца сезона-2021/22."
                        ),
                        EventContent(
                            ContentType.PARAGRAPH,
                            "До перехода в УНИКС Мосли выступал за черногорский «Морнар», где в 19 матчах Адриатической лиги в среднем набирал 6,4 очка и делал 4,8 подбора за игру."
                        ),
                        EventContent(
                            ContentType.PARAGRAPH,
                            "В прошлом сезоне американец защищал цвета «Партизана»."
                        )
                    )
                )
            ),
			//endregion

			//region ===================== ARTICLE ======================
            Event(
                url = "https://sport24.ru/news/mma/2022-04-15-sidelnikov-uveren-v-pobede-nemkova-anderson-slabeye-vadima",
                id = "a1",
                type = EventType.ARTICLE,
                publishDate = Date(1650043920),
                data = EventDataArticle(
                    backgroundImage = "https://s74794.cdn.ngenix.net/api/v1/images/aa4e/256b/bc50/0e85/a78e/1379/4091/322f/1100_10000_max.jpeg", // TODO всегда
                    title = "Сидельников сделал прогноз на бой Вадим Немков — Кори Андерсон",
                    tags = listOf(
                        EventTag(
                            "2",
                            "https://s74794.cdn.ngenix.net/m/0a09/7019/83d8/8eaa/4ea1/cb7e/a999/7ee0/300_300_max.png"
                        ) // TODO 300_300_max.png
                    ),
                    image = "https://s74794.cdn.ngenix.net/m/d47d/6117/6fe7/4a67/b88e/2cb7/0020/c6ee/1100_10000_max.jpeg",  // TODO 1100_10000_max.jpeg
                    content = listOf(
                        EventContent(
                            ContentType.PARAGRAPH,
                            "Российский боец смешанных единоборств Кирилл Сидельников поделился ожиданиями от боя Вадим Немков — Кори Андерсон. Поединок Немкова c Андерсоном в финале Гран-при Bellator пройдет в ночь 16 апреля мск в Сан-Хосе (штат Калифорния, США)."
                        ),
                        EventContent(
                            ContentType.HEADER,
                            "Прогноз: победа Немкова за 1.65 (сделать прогноз можно бесплатно, получив до 3 фрибетов по 500 рублей в мобильном приложении БЕТСИТИ)."
                        ),
                        EventContent(
                            ContentType.PARAGRAPH,
                            "«К этому поединку Вадим начал готовиться очень давно. Дата боя постоянно менялась, хотя об этом никто не объявлял. Сначала говорили, что он состоится в феврале, потом речь шла о марте, а в итоге он был назначен на апрель. И все это время Немков держал себя в форме, тренировался, что довольно непросто на протяжении такого длительного срока. Вадим — большой профессионал. К каждой схватке он подходит в идеальной форме. Его никогда нельзя упрекнуть в отсутствии старания, в желании сачкануть. В этом плане Немков — настоящий чемпион, пахарь."
                        ),
                        EventContent(
                            ContentType.PARAGRAPH,
                            "Что касается Андерсона, то лично я не считал его сильным соперником. Не думал, что он доберется до финала, ведь в той подгруппе были и более сильные бойцы. Его успех стал для меня неожиданностью. Возможно, немного недооцениваю Андерсона, но лишь из-за уверенности в успехе Немкова. Думаю, Кори ему по зубам. И этот поединок станет для Вадима не самым сложным не только в карьере, но и в рамках Гран-при."
                        ),
                        EventContent(
                            ContentType.PARAGRAPH,
                            "Когда я узнал имена участников турнира, то наравне с Немковым считал фаворитом Фила Дэвиса. Это очень тягучий, неудобный боец. Плюс Андерсона в том, что он обладает мощным одиночным ударом, способным решить исход схватки. Но Вадим превосходит его во всем — «физике», выносливости, обладает более богатым техническим арсеналом."
                        ),
                        EventContent(
                            ContentType.PARAGRAPH,
                            "Если брать всех соперников в карьере Немкова, то в пятерку Андерсон входит. Но хоть я и считаю его не таким сильным бойцом, Андерсон все же обладает большим опытом. Он выступал в UFC, дрался с именитыми бойцами. Но, по моему субъективному мнению, он слабее Вадима. Возможно, я просто очень сильно болею за Немкова и желаю ему победы», — цитирует Сидельникова RT."
                        ),
                        EventContent(
                            ContentType.PARAGRAPH,
                            "Бой Немков — Андерсон ориентировочно начнется в 05:00 по московскому времени."
                        ),
                        EventContent(
                            ContentType.PARAGRAPH,
                            "Аналитики БЕТСИТИ также склоняются к победе Немкова. На победу Андерсона можно поставить за 2.30."
                        )
                    )
                )
            ),
			//endregion

			//region ===================== PHOTO_ALBUM ======================
            Event(
                url = "https://sport24.ru/photo/figureskating/2022-04-14-shou-eteri-tutberidze-v-moskve-foto-dekolte-medvedevoy-novyy-nomer-trusovoy-zagitova-kvitelashvili-tuktamysheva-kolyada-shcherbakova-fotogalereya",
                id = "p1",
                type = EventType.PHOTO_ALBUM,
                publishDate = Date(1649930700),
                data = EventDataPhotoAlbum(
                    backgroundImage = "https://s74794.cdn.ngenix.net/api/v1/images/aa4e/256b/bc50/0e85/a78e/1379/4091/322f/1100_10000_max.jpeg", // TODO всегда
                    title = "Декольте Медведевой, Трусова в голубом топе под Елку, букет для Тутберидзе: Москва увидела шоу лучших фигуристов",
                    sport = "figureskating",
                    photoUrlList = listOf(
                        "https://s74794.cdn.ngenix.net/m/99b6/7b37/c5e7/4451/b605/41d5/9940/fd7a/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/a7f9/9ccc/e6f9/4c5b/afed/40c2/4764/0fb2/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/044e/5cfe/8cc0/42c9/a280/40fd/60c2/51aa/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/7db9/9398/62ef/42c4/bbce/3d2c/fabc/128c/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/15d1/a7fd/3fdd/4877/81a9/e36a/a44a/0c3f/3200_2000_max.jpeg",

                        "https://s74794.cdn.ngenix.net/m/695c/08cc/5084/4f44/bbcd/ca19/b843/6ece/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/3ecc/69b0/3acf/4c1e/9cd3/5125/df74/35e3/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/d77a/ddb3/4689/478c/b1dd/7e71/66b2/412e/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/5896/b332/c8f7/4e5c/9c13/4431/702a/f908/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/a7f2/a231/5c61/4600/af1c/90e4/ec9e/8385/3200_2000_max.jpeg",

                        "https://s74794.cdn.ngenix.net/m/8c3c/5688/5a54/4de5/9ea7/547f/44a7/cd80/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/7b18/7d73/4512/4a3b/a52d/7e7a/a74e/f58b/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/5d3e/a0e5/1b6e/4075/ae37/83c7/8c02/7f7a/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/1cf3/0d87/b8ce/4f35/9f89/7d1c/17c6/89ce/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/4a31/49c9/2837/4cfb/8cd9/8fdb/300f/64fa/3200_2000_max.jpeg",

                        "https://s74794.cdn.ngenix.net/m/9e1c/c756/d3a1/4d88/a905/a341/c88a/849b/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/9695/ebca/da33/4034/9c9c/64b2/b3de/b0cc/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/9a16/5b7b/5e99/47c2/85aa/7126/2134/e658/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/2c4a/5c67/81c8/41b5/8121/63dc/d76a/b381/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/8fa3/f334/5c4b/4439/a558/39f0/8c4b/40b6/3200_2000_max.jpeg",

                        "https://s74794.cdn.ngenix.net/m/2474/e77b/810b/4e4c/adea/abde/b8fa/7b24/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/3644/bae6/10c8/4a20/ab07/5210/fb23/cbc6/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/3e2a/e071/e4ec/4bf0/a463/6dca/85bb/e6bf/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/8d0b/1391/38c9/4649/b7fc/ce11/9d7c/48c3/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/a60c/c5ef/dbab/4092/8a2e/2535/6d2e/6106/3200_2000_max.jpeg",

                        "https://s74794.cdn.ngenix.net/m/627b/dc32/2fd1/4e90/9716/0c65/4290/9837/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/7830/14fb/18fe/4022/a366/a69b/97c7/06ff/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/1699/e0d3/55c4/4bd9/85ab/b4b0/cfd8/774e/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/b677/4ad5/4397/4cf9/b89a/a232/fb18/6f64/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/c482/11c8/bf89/49fe/ab7d/1fdb/815a/5ebd/3200_2000_max.jpeg",

                        "https://s74794.cdn.ngenix.net/m/b1c6/c400/17f5/46f9/a4ba/d273/e051/ff74/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/b402/6542/7eb5/4e24/8804/a534/3fcf/6a4f/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/1e80/ccfd/ed26/4a00/bc9b/1ce7/8023/72c9/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/452a/4f96/5cd5/4937/8a29/ed80/2540/77b0/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/2f17/efdc/adcb/4743/ac73/9965/6a11/2671/3200_2000_max.jpeg",

                        "https://s74794.cdn.ngenix.net/m/5cec/b8a0/70d7/44da/99e6/1ef9/fd38/d11c/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/785c/9372/bbd4/4b3b/ad0a/98a5/2ebd/33fb/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/74db/d079/60f8/445a/b923/c9aa/c4ae/44dd/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/a1c7/3d7b/218f/4a84/a77d/0462/304e/b621/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/ef97/f034/be27/4930/8dcc/50b2/8758/dcbf/3200_2000_max.jpeg",

                        "https://s74794.cdn.ngenix.net/m/60fa/e215/2ecd/488c/9e8b/d299/9a12/63a8/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/751a/fde5/0d5c/44d9/8c14/94a8/e7f2/920f/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/6237/2b73/e598/457b/b328/0c2c/ab09/aa8f/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/e32e/3269/783b/4d65/ba44/0e47/53d0/dd07/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/f184/2cf6/c85e/4d7e/b6f6/807e/3ff7/fda8/3200_2000_max.jpeg",

                        "https://s74794.cdn.ngenix.net/m/385d/b104/e842/4bdd/b6c9/6a0b/ba5f/fe02/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/c798/431c/e31c/4af3/b94f/93ce/c629/7a5b/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/f7cd/16be/3cc1/401d/ae3b/5f29/56b3/8029/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/b8f2/bd32/1aaf/442e/bc6b/b1a1/e85f/e143/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/4a86/1c3b/d25c/4f12/997d/65bb/6c37/f5cd/3200_2000_max.jpeg",

                        "https://s74794.cdn.ngenix.net/m/18f2/e18b/ecdb/4113/9c76/736c/0e40/1acb/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/3221/798c/a5ea/450d/aad9/b662/4d47/6aee/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/f6b1/596f/3312/45fc/9106/5220/2917/4b40/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/5603/ab87/b4e8/4595/a389/2fb1/6d79/c24d/3200_2000_max.jpeg",
                        "https://s74794.cdn.ngenix.net/m/cf2d/837a/29cc/4924/b933/790f/2c18/067f/3200_2000_max.jpeg",

                        "https://s74794.cdn.ngenix.net/m/475b/87f4/f162/4ca0/be8e/5ff3/96a8/c238/3200_2000_max.jpeg"
                    )
                )
            ),
			//endregion

			//region ===================== BROADCAST ======================
            Event(
                url = "https://sport24.ru/live/mma/2022-04-08-petr-yan-sterling-chimayev-berns-ufc-273-pryamaya-translyatsiya-smotret-prognoz-foto-video",
                id = "b1",
                type = EventType.BROADCAST,
                publishDate = Date(1649566800),
                data = EventDataBroadcast(
                    backgroundImage = "https://s74794.cdn.ngenix.net/api/v1/images/aa4e/256b/bc50/0e85/a78e/1379/4091/322f/1100_10000_max.jpeg", // TODO всегда
                    title = "Петра Яна засудили в UFC, Чимаев с трудом прошел Бернса, а Олейник финишировал соперника за 3 минуты. Как это было",
                    tags = listOf(
                        EventTag(
                            "3",
                            "https://s74794.cdn.ngenix.net/m/9095/9898/8526/059a/226b/48bd/3965/4c08/300_300_max.png"
                        ), // TODO 300_300_max.png
                        EventTag(
                            "4",
                            "https://s74794.cdn.ngenix.net/m/4141/cf0b/aa59/d75a/feb4/f0a5/60af/808c/300_300_max.png"
                        ), // TODO 300_300_max.png
                        EventTag(
                            "5",
                            "https://s74794.cdn.ngenix.net/m/4259/ae54/1620/4686/ae7c/4f39/eea3/2c4b/300_300_max.png"
                        ), // TODO 300_300_max.png
                        EventTag(
                            "6",
                            "https://s74794.cdn.ngenix.net/m/5546/2c97/90eb/4d23/a27b/ad87/295c/935e/300_300_max.png"
                        ), // TODO 300_300_max.png
                        EventTag(
                            "7",
                            "https://s74794.cdn.ngenix.net/m/3498/26c7/8092/4fae/bf37/8209/d27d/0b02/300_300_max.png"
                        ), // TODO 300_300_max.png
                        EventTag(
                            "8",
                            "https://s74794.cdn.ngenix.net/m/25ea/fae1/eadb/f4f3/7d22/10ea/3fce/9645/300_300_max.png"
                        ), // TODO 300_300_max.png
                        EventTag(
                            "9",
                            "https://s74794.cdn.ngenix.net/m/147d/7a8f/63c1/4421/ea9a/0881/bbdb/74fa/300_300_max.png"
                        ) // TODO 300_300_max.png
                    ),
                    liveEvents = listOf(
                        BroadcastLiveEvent(
                            publishDate = Date(1649580000),
                            content = listOf(
                                EventContent(
                                    ContentType.HEADER,
                                    "UFC 273 получился довольно-таки сенсационным. Алексей Олейник в свои 44 года одержал яркую победу в первом раунде над Джаредом Вандераа."
                                ),
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Хамзат Чимаев впервые в карьере провел полный бой, проиграв раунд и получив рассечение. Но это не помешало шведскому чеченцу выиграть у Гилберта Бернса по очкам."
                                ),
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Самое обидное событие турнира — поражение Петра Яна в реванше со Стерлингом спорным решением судей. Петр посчитал, что забрал первый раунд, поэтому расслабился во втором и третьем, убедительно взяв лишь четвертый и пятый. Но оказалось, что судьи первую пятиминутку отдали Стерлингу."
                                ),
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Единственный, кто выиграл без вопросов в центральном бою — Александр Волкановски. Зомби неплохо отвечал, но бой все равно смотрелся как одностороннее избиение."
                                )
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649579520),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Все! Херб Дин остановил бой после очередного жесткого попадания Волкановски. Да, Зомби устоял, но видно было, что он потрясен. Заслуженная и довольно легкая с виду победа чемпиона ТКО в четвертом раунде."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649579400),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "На последних секундах третьего раунда Зомби упал в нокдаун, но не дал себя добить. Если так продолжится, судьи попросту могут остановить избиение."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649579100),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Второй раунд также в одну калитку забрал Волкановски, которому снова удалось потрясти Зомби. По ударом в голову у австралийца почти трехкратное преимущество."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649578620),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Бой Волкановски и Зомби пока получается односторонним. Кореец несколько раз был потрясен и, как кажется, проиграл первый раунд со счетом 10-8."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649578200),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Большинство аналитиков и экспертов также склоняются к победе Стерлинга. Остается надеяться, что в скором времени мы увидим реванш."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649577600),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "«Я считаю, что я выиграл этот бой. Вы меня обокрали! Считаю, что выиграл три раунда из пяти. Джо Роган, я хочу рематч. Я выиграл первый раунд, четвертый и пятый. Я хочу рематч», — сказал Петр Ян в интервью Джо Рогану сразу после боя."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649577360),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Завершается программа UFC 273 чемпионским боем в полулегком весе. Александр Волкановски сразится с Корейским Зомби. Еще один поединок, в котором, по мнению букмекеров, есть очевидный фаворит. Прошлые два (Ян — Стерлинг, Чимаев — Бернс) оказались крайне конкурентными."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649577060),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Как же обидно. Дважды 48:47 и 47:48 — победа Стерлинга раздельным решением судей. Довольно странное решение, учитывая, что американец почти не дрался в стойке и за весь бой провел лишь два тейкдауна из 22 попыток."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649576880),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Конец! Пятый раунд тоже оказался крайне тревожным, вот только теперь Петр не отдавал спину и спокойно разбирал Стерлинга в стойке и однажды встретил коленом. Практически избиение получилось. В концовке Петр умудрился забрать спину и попытался провести удушающий, но времени не хватило."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649576340),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH, "\n" +
                                            "Очевидно, что Стерлинг ловит Петра в момент киков, но Петр продолжает их бить и оказывается не в лучших положениях. В очередной попытке Стерлинга забрать спину Ян вырвался и оказался в гарде, работая на очки. Это лучшее решение в ситуации, когда ты проигрываешь."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649576100),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Третий раунд стал таким же, как и второй. Петр активно поджимал, защитился от нескольких тейкдаунов, но затем прозевал новую попытку и отдал спину, пытаясь встать на ноги. По раундам Стерлинг точно впереди как минимум со счетом 2-1."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649575740),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Второй раунд оказался на порядок тревожнее. Петр защитился от прохода, но не смог вовремя встать на ноги, а Стерлинг заскочил в фулл-маунт, после чего забрал спину. Вот только Ян в таких положения был крайне часто, особенно в начале своей карьеры, поэтому уверенно отзащищался до конца второго раунда."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649575380),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Первый раунд позади. Сразу отмечаем, что Стерлинг провел работу над ошибками и теперь работает исключительно вторым номером, не выбрасывая лишние удары. Кроме киков и попытки тейкдауна американец ничем не отметился."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649575080),
                            content = listOf(
                                EventContent(ContentType.PARAGRAPH, "Бой Петра Яна стартовал!"),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649574900),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "«Я не ожидал, что он такой жесткий парень. Не ожидал. Он вышел сюда и показал бразильский дух. Я знаю бразильцев, они с духом, у меня много братьев бразильцев Мой тренер по БЖЖ бразилец, я знаю его много лет, он мне помогает с первого дня, они жесткие ребята, бразильцы. Я вышел сюда сделать мою работу и забрать мои деньги. Уважение Гилберту, брат, ты показал сердце сегодня. Он был очень хорош сегодня, я не ожидал, что он настолько сильный, не ожидал, что он так начнет. Он должно быть пахал как не знаю кто к этому бою, ведь я сам пахал еще как. Никогда не прекращал свои тренировки. Но он очень жесткий. Я давно хотел такого боя, у меня было 10 побед и 10 финишей, а теперь я окровавлен, я устал, мне больно, но я люблю это», — сказал Чимаев сразу после боя с Бернсом."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649574360),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Ждем Петра Яна и Алджамейна Стерлинга. Многие знают историю их противостояния. Началось все год назад, когда Петр Ян в одну калитку разбирал Стерлинга, позволив себе запрещенный удар коленом. Победу и пояс отдали американцу. А сейчас долгожданный реванш, который закроет вопрос между бойцами."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649573940),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Судьи единогласно отдают победу Чимаеву. Да, крайне тяжелый бой получился для Хамзата. В интервью Джо Рогану Хамзат признал мощь Бернса и сказал, что не ожидал такого трудного поединка."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649573460),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Первый третий раунд Чимаева в UFC. И сразу же Хамзат зажал Бернса у сетки и старается финишировать в стойке. Но не удается — бразилец здорово держит удар, а в концовке даже взрывается серией, на которую Чимаев не ответил. Бразилец выдержал испытание, а шведский чеченец, скорее всего, нет. Ждем судейское решение."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649573220),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Слишком часто пропускает Чимаев во втором раунде. Много разменов, в которых Бернс смотрится все увереннее и увереннее. Стоит отметить, что Хамзат не идет в борьбу, но хорошо защищается. И снова пропускает навстречу Чимаев, но в последний момент собирается и оформляет тейкдаун."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649572800),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Поднялись бойцы в стойку. Несколько разменов в стойке! Первые удары пропустил Чимаев в UFC. Роняет Бернса джебом! Но добить не удается, спасается бразилец, и раунд заканчивается."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649572740),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Поехали! И Хамзат сразу же давит Бернса к сетке и идет в борьбу, но завалить бразильца с первой попытки не удалось. Но затем все же перевел!"
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649571840),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Дождались! Совсем скоро на арене появятся Хамзат Чимаев и Гилберт Бернс. Самый интригующий бой UFC 273, который может оказаться самым односторонним. Посмотрим."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649571600),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Крайне тяжелый бой для судейства. 29:28, 28:29 и 29:28 — победа Маккензи Дерн раздельным решением. В чем-то справедливое решение, ведь именно Дерн работала первым номером и угрожала сабмишенами, тогда как Торрес бегала по клетке и отбивалась в стиле Джона Джонса киками."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649569800),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Впереди бой девушек. Маккензи Дерн — титулованная представительница бразильского джиу-джитсу. Тиша Торрес — ветеран UFC, идущая на серии из трех побед. Будет интересно."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649569680),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Марк Мадсен одержал уверенную победу единогласным решением судей (дважды 30:27 и 29:28). Интересный боец, но говорить о топ-уровне сложно. Даже 39-летний Пичел неплохо смотрелся на фоне олимпийского призера."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649568060),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "До боя Хамзата Чимаева и Гилберта Бернса остается около часа. Прямо сейчас в клетке сойдутся 39-летний ударник Винс Пичел и 37-летний обладатель серебряной медали Рио по греко-римской борьбе Марк Мадсен."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649567460),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Перемещаемся в Джексонвилль, где совсем скоро начнется основной кард турнира UFC 273. Несколько часов назад ярчайшей победой отметился легендарный Алексей Олейник. Харьковчанин уверенно разобрал Джареда Вандераа за 3,5 минуты, оформив 47-ю победу сабмишеном в карьере."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649592000),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Битвы взглядов получились максимально горячими."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649613000),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Накануне прошла официальная церемония взвешивания. Все участники главных боев вечера сделали вес."
                                ),
                            )
                        ),
                        BroadcastLiveEvent(
                            publishDate = Date(1649548800),
                            content = listOf(
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "В ночь на 10 апреля в Джексонвилле состоится турнир UFC 273. Бои Петра Яна и Хамзата Чимаева стоят особняком в сравнении с остальными поединками карда. Обладатель временного титула UFC из России поставит жирную точку в отношениях с Алджамейном Стерлингом, годом ранее завоевавшим пояс благодаря дисквалификации Петра. Чимаева ждет настоящая, как думают эксперты, проверка в лице бывшего претендента на титул Гилберта Бернса."
                                ),
                                EventContent(
                                    ContentType.PARAGRAPH,
                                    "Также не обойдем стороной главный бой мейн-карда: Александр Волкановски зарубится с Корейским Зомби. Впереди много интересного и захватывающего. Начинаем следить за самыми жаркими событиями с 06:00 по московскому времени."
                                ),
                            )
                        )
                    ),
                    live = false
                )
            ),
			//endregion

			//region ===================== PHOTO_ALBUM ======================
			Event(
				url = "https://sport24.ru/photo/hockey/2022-04-12-kkhl-pley-off-tsska-ska-3-1-sravnyali-ravil-yakubov-krov-shayba-v-litso-foto-obzor-matcha",
				id = "p2",
				type = EventType.PHOTO_ALBUM,
				publishDate = Date(1649793600),
				data = EventDataPhotoAlbum(
					backgroundImage = "https://s74794.cdn.ngenix.net/api/v1/images/aa4e/256b/bc50/0e85/a78e/1379/4091/322f/1100_10000_max.jpeg", // TODO всегда
					title = "Игрок ЦСКА в кровь разбил лицо своему тренеру, финский провокатор из СКА уселся на голову русскому хоккеисту: фото",
					sport = "hockey",
					photoUrlList = listOf(
						"https://s74794.cdn.ngenix.net/m/6f9a/1e02/b8f6/4809/a5bc/9b1a/7609/a651/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/8d55/736f/6ccd/4a3c/8765/0e74/161e/15d1/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/4d7a/296d/f1e8/47ae/9d05/a93b/acb5/676b/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/be00/39e5/8996/44a3/bfde/c881/c89d/49a0/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/b2b9/6f53/e38e/433d/8d58/6d58/82be/a8ac/3200_2000_max.jpeg",

						"https://s74794.cdn.ngenix.net/m/3e3e/c6f5/fb64/4d40/a1ee/2cac/be55/b20e/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/b503/4d64/5531/4b49/a920/9755/2486/57a5/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/1f02/34d2/a3cf/4db0/9d7e/2e59/1b72/778c/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/6659/7342/74b6/4aba/ad93/a632/c63b/a7bc/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/84b4/28f8/deb9/4682/a66a/bd27/c098/6f55/3200_2000_max.jpeg",

						"https://s74794.cdn.ngenix.net/m/454d/37b4/abff/40ee/9e01/2d48/fb08/2dcb/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/0ded/c59b/0226/4670/b10d/dec9/ded1/2b61/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/f0e4/ff99/0aff/4869/bfdb/7365/029f/3e8d/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/716b/148e/00e8/4d8b/beba/6ceb/2a51/5f17/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/9100/1039/c9fb/4784/81e1/371a/66bf/06c9/3200_2000_max.jpeg",

						"https://s74794.cdn.ngenix.net/m/761a/8cac/6318/454a/81f1/87f0/dd8b/2ca0/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/a570/e345/5fa9/432a/8bab/ddf4/189f/f7dc/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/9972/5274/5d87/4322/8b50/af09/b84e/afda/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/cae1/ef75/99ae/4955/b46a/691a/1dc9/2430/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/4a61/8281/e682/4a86/9f83/88e7/b1c2/e66f/3200_2000_max.jpeg",

						"https://s74794.cdn.ngenix.net/m/d82e/f6dd/8c0d/4cb1/ad97/d478/5fd3/8fa1/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/8147/fd70/54a2/4fa0/87de/787a/8700/cbbe/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/051c/2e8d/e216/4a44/b449/e639/505b/392a/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/976e/66d9/0b43/41b7/a7c8/d909/c804/62af/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/c146/dd82/8078/4223/ab41/0246/ee2c/3205/3200_2000_max.jpeg",

						"https://s74794.cdn.ngenix.net/m/76b5/a131/0179/44bd/b869/e601/ed7d/b276/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/42f9/a435/75bb/420e/bb11/420f/78b3/d546/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/aae9/d5ca/a2cf/4bd3/9b10/9ee6/437f/b39d/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/023b/107c/a52f/494c/9a5e/7c04/db64/b489/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/bcbe/34c3/e55c/4762/a5c0/0f80/d0e0/0e98/3200_2000_max.jpeg",
					)
				)
			),
			//endregion

			//region ===================== PHOTO_ALBUM ======================
			Event(
				url = "https://sport24.ru/photo/football/2022-04-10-rpl-spartak-arsenal-tula-3-0-foto-obzor-matcha-goly-zobnin-nikolson-zhest",
				id = "p3",
				type = EventType.PHOTO_ALBUM,
				publishDate = Date(1649615400),
				data = EventDataPhotoAlbum(
					backgroundImage = "https://s74794.cdn.ngenix.net/api/v1/images/aa4e/256b/bc50/0e85/a78e/1379/4091/322f/1100_10000_max.jpeg", // TODO всегда
					title = "Федун молился, Николсон показывал орла, Хлусевич обнимался с туляками. Главные фото победы «Спартака»",
					sport = "football",
					photoUrlList = listOf(
						"https://s74794.cdn.ngenix.net/m/11d7/ba58/d0bf/4c03/9513/8822/5e6f/dd22/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/1f43/9cb5/4fb0/4e09/ab22/3132/b41b/ef33/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/b963/dca7/044a/46af/8a52/9ea2/57eb/20c2/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/56f1/d847/3c2f/4462/9bc0/f709/4808/3c2a/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/1ddd/32e8/00e1/4054/9859/b209/189c/c929/3200_2000_max.jpeg",

						"https://s74794.cdn.ngenix.net/m/e830/bc09/4c1c/4428/ad29/4707/7676/6841/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/320c/1751/b835/41bc/8d83/9241/f2c0/35ae/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/046e/0f7b/bbb6/45eb/a45e/d5a8/341a/1342/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/840d/165b/aab3/4e55/b163/ac19/e75e/0ae0/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/40e3/ba0b/f3b9/45c2/942f/337b/b9d3/7acb/3200_2000_max.jpeg",

						"https://s74794.cdn.ngenix.net/m/e21c/f12d/cd6d/418c/9e9e/f315/ca17/104b/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/aeec/fe03/425a/4168/a7e3/cbd8/f91f/79b5/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/7d3c/950d/343d/413b/9556/5c2e/19a1/5df8/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/4a2d/879b/5d7d/4515/9cc6/8c45/58c5/02f0/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/86e5/d232/660d/4178/ae0e/6d37/1478/b1a2/3200_2000_max.jpeg",

						"https://s74794.cdn.ngenix.net/m/3850/9ed3/97d4/41b5/b9c1/da49/e4fe/9622/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/17f4/76ba/1d15/4708/9f33/0bd2/b257/371b/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/9a84/cf79/963a/47dd/b613/f687/0bca/9b7d/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/0cf5/5ba7/b7d1/4acf/ab0d/b7fe/a096/2adf/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/f625/343f/7af4/43f7/89bf/3e41/413d/6700/3200_2000_max.jpeg",

						"https://s74794.cdn.ngenix.net/m/a0fc/a712/f315/4af5/99aa/ccb8/35c7/972c/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/2ffc/3df4/3736/467f/b582/181e/a807/81ef/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/f4f4/b492/6d2f/415a/8c78/1083/93e5/36a0/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/6eab/4d2a/cb0f/45cc/b962/6e8d/7ef9/3c75/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/ce5a/2844/14a7/4aa6/932f/07f5/89b8/0254/3200_2000_max.jpeg",

						"https://s74794.cdn.ngenix.net/m/8d1f/454c/0afb/4807/823d/0884/1587/5d1a/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/413a/06eb/3565/417a/b6dc/df0f/bd73/1f2c/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/6d7a/1a2a/98f5/4e0e/abbe/10ae/0e89/846a/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/cd0b/7b91/9bf3/4b3c/aec9/7d5a/09c5/6d00/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/2531/1b20/cbda/4808/9ca1/3cd6/e7bd/d804/3200_2000_max.jpeg",
					)
				)
			),
			//endregion

			//region ===================== PHOTO_ALBUM ======================
			Event(
				url = "https://sport24.ru/photo/mma/2022-04-10-petr-yan-proigral-sterlingu-chimayev-pobedil-bernsa-oleynik-sabmishenom-pobedil-vanderu-luchshiye-foto-ufc-273",
				id = "p4",
				type = EventType.PHOTO_ALBUM,
				publishDate = Date(1649577600),
				data = EventDataPhotoAlbum(
					backgroundImage = "https://s74794.cdn.ngenix.net/api/v1/images/aa4e/256b/bc50/0e85/a78e/1379/4091/322f/1100_10000_max.jpeg", // TODO всегда
					title = "Соперника Яна встретили в США средними пальцами, Чимаев пустил кровь, Олейник задушил американца с маникюром: фото",
					sport = "mma",
					photoUrlList = listOf(
						"https://s74794.cdn.ngenix.net/m/03b7/1bf5/49e9/4ba0/9735/8eec/2835/f718/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/f3ef/c4ca/e166/4d78/af17/87ce/3cad/63c1/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/99b5/7a1e/b378/47c8/acab/fcb6/d3cc/a3c9/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/a49a/8084/ebe2/4371/9d6d/82bb/4f10/c005/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/077f/2ad6/752b/481f/9e0a/c9d4/c33c/e2af/3200_2000_max.jpeg",

						"https://s74794.cdn.ngenix.net/m/d7bb/9753/83b4/4e60/ab79/194f/0749/b764/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/37a7/ed3c/5344/4c8d/b473/7271/98cb/fdba/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/448b/5e84/0c34/450a/b2a7/e43b/af8d/60a5/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/265d/3ccc/3448/410a/b481/07b5/9f18/ca82/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/e207/557a/8619/45fc/af67/ed45/7120/6e83/3200_2000_max.jpeg",

						"https://s74794.cdn.ngenix.net/m/ecc1/67fd/1db0/4781/ab3d/4ca6/ea8b/0288/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/05f4/f9d0/4f66/4613/8c81/15c7/e54f/306f/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/468b/15ac/0d31/4ea4/826a/7dd3/0cc4/a9ff/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/f692/e492/fa8d/416b/a803/8b40/3cff/62be/3200_2000_max.jpeg",
						"https://s74794.cdn.ngenix.net/m/98e0/1d50/4bcb/48be/8b02/07fe/d9c5/342a/3200_2000_max.jpeg",
					)
				)
			),
			//endregion

			//region ===================== BROADCAST ======================
			Event(
				url = "https://sport24.ru/live/football/2022-04-19-alaniya-zenit-translyatsiya-gde-smotret-onlayn-video-20aprelya-2022-kubok-rossii",
				id = "b2",
				type = EventType.BROADCAST,
				publishDate = Date(1650463140),
				data = EventDataBroadcast(
					backgroundImage = "https://s74794.cdn.ngenix.net/api/v1/images/aa4e/256b/bc50/0e85/a78e/1379/4091/322f/1100_10000_max.jpeg", // TODO всегда
					title = "Питерцы экзаменуют владикавказцев в четвертьфинале Кубка России. «Алания» — «Зенит» 0:0 LIVE!",
					tags = listOf(
						EventTag(
							"10",
							"https://s74794.cdn.ngenix.net/m/5cf4/14a7/fbd0/4539/fdb3/e474/b08a/4eea/300_300_max.png"
						), // TODO 300_300_max.png
						EventTag(
							"11",
							"https://s74794.cdn.ngenix.net/m/2bde/35bc/b2e3/41e8/8888/88e0/454d/f0bc/300_300_max.png"
						), // TODO 300_300_max.png
						EventTag(
							"12",
							"https://s74794.cdn.ngenix.net/m/3505/bf38/16c4/33a0/691f/e5a0/85f0/8d47/300_300_max.png"
						), // TODO 300_300_max.png
						EventTag(
							"13",
							"https://s74794.cdn.ngenix.net/m/33da/7aa8/7414/eecf/037f/33fb/59c9/6586/300_300_max.png"
						), // TODO 300_300_max.png
					),
					liveEvents = listOf(
						BroadcastLiveEvent(
							publishDate = Date(1650466020),
							content = listOf(
								EventContent(
									ContentType.HEADER,
									"Перерыв! Пока что довольно скучная у нас игра в Грозном. Обе команды не блистают, не видим мы толком и опасных моментов."
								),
							)
						),
						BroadcastLiveEvent(
							publishDate = Date(1650465780),
							content = listOf(
								EventContent(
									ContentType.PARAGRAPH,
							"Круговой прошел вперед по левому флангу, прострелил в чужую штрафную на Дзюбу, но Артему нанести завершающий удар так и не удалось. Мячом завладел Солдатенко."
								),
							)
						),
						BroadcastLiveEvent(
							publishDate = Date(1650465600),
							content = listOf(
								EventContent(
									ContentType.PARAGRAPH,
							"Кобесов получил желтую карточку за грубый фол против Алипа поблизости от чужой штрафной."
								),
							)
						),
						BroadcastLiveEvent(
							publishDate = Date(1650465480),
							content = listOf(
								EventContent(
									ContentType.PARAGRAPH,
									"А теперь после заброса в штрафную «Алании» во вне игры оказался Ерохин."
								),
							)
						),
						BroadcastLiveEvent(
							publishDate = Date(1650465360),
							content = listOf(
								EventContent(
									ContentType.PARAGRAPH,
									"Гурциев забрался во вне игры сейчас у чужой штрафной."
								),
							)
						),
						BroadcastLiveEvent(
							publishDate = Date(1650465240),
							content = listOf(
								EventContent(
									ContentType.PARAGRAPH,
									"Кобесов отдал пас пяткой, после чего Хубулов пробил из пределов штрафной в ближний угол ворот, но Кержаков среагировал."
								),
							)
						),
						BroadcastLiveEvent(
							publishDate = Date(1650465120),
							content = listOf(
								EventContent(
									ContentType.PARAGRAPH,
									"Достойно смотрится в первые полчаса матча «Алания». Ничего пока хозяева не позволяют создать более именитым гостям."
								),
							)
						),
						BroadcastLiveEvent(
							publishDate = Date(1650465000),
							content = listOf(
								EventContent(
									ContentType.PARAGRAPH,
									"Ерохин из центра чужой штрафной попробовал головой сбросить мяч на дальнюю штангу, но там Дзюба до мяча не дотянулся."
								),
							)
						),
						BroadcastLiveEvent(
							publishDate = Date(1650464820),
							content = listOf(
								EventContent(
									ContentType.PARAGRAPH,
									"Шавлохов получил желтую карточку за задержку руками Мостового."
								),
							)
						),
						BroadcastLiveEvent(
							publishDate = Date(1650464640),
							content = listOf(
								EventContent(
									ContentType.PARAGRAPH,
									"Кобесов прошел вперед по левому флангу, исполнил прострел в чужую штрафную, но там мяч стал легкой добычей для Кержакова."
								),
							)
						),
						BroadcastLiveEvent(
							publishDate = Date(1650464460),
							content = listOf(
								EventContent(
									ContentType.PARAGRAPH,
									"Два кряду угловых заработали и разыграли сейчас хозяева поля. Однако, все без создания опасных моментов."
								),
							)
						),
						BroadcastLiveEvent(
							publishDate = Date(1650464280),
							content = listOf(
								EventContent(
									ContentType.PARAGRAPH,
									"Хорошую контратаку могли сейчас провести хозяева, но здорово сыграл на перехвате Барриос."
								),
							)
						),
						BroadcastLiveEvent(
							publishDate = Date(1650464100),
							content = listOf(
								EventContent(
									ContentType.PARAGRAPH,
									"Шавлохов получил повреждение в единоборстве с Ерохиным. Пауза у нас в игре."
								),
							)
						),
						BroadcastLiveEvent(
							publishDate = Date(1650463980),
							content = listOf(
								EventContent(
									ContentType.PARAGRAPH,
									"Чистяков здорово сыграл на перехвате в своей штрафной после длинной передачи из глубины поля."
								),
							)
						),
						BroadcastLiveEvent(
							publishDate = Date(1650463860),
							content = listOf(
								EventContent(
									ContentType.PARAGRAPH,
									"Адамов подключился к атаке своей команды по правому флангу, навесил в чужую штрафную, но мяч стал легкой добычей для Солдатенко."
								),
							)
						),
						BroadcastLiveEvent(
							publishDate = Date(1650463740),
							content = listOf(
								EventContent(
									ContentType.PARAGRAPH,
									"Гурциев упал на газон в борьбе за мяч в чужой штрафной, но арбитр фола не зафиксировал."
								),
							)
						),
						BroadcastLiveEvent(
							publishDate = Date(1650463620),
							content = listOf(
								EventContent(
									ContentType.PARAGRAPH,
									"Хабалов перестарался в борьбе за мяч поблизости от чужой штрафной. Фол в атаке зафиксировал арбитр."
								),
							)
						),
						BroadcastLiveEvent(
							publishDate = Date(1650463500),
							content = listOf(
								EventContent(
									ContentType.PARAGRAPH,
									"Хозяева пробуют также активно действовать на стартовых минутах нашего матча. Но пока без создания опасных моментов у них."
								),
							)
						),
						BroadcastLiveEvent(
							publishDate = Date(1650463380),
							content = listOf(
								EventContent(
									ContentType.PARAGRAPH,
									"Мостовой сместился с левого фланга атаки к центру у чужой штрафной, на силу попытался пробить, но отправил мяч далеко от цели."
								),
							)
						),
						BroadcastLiveEvent(
							publishDate = Date(1650463260),
							content = listOf(
								EventContent(
									ContentType.HEADER,
									"Матч начался!"
								),
							)
						),
						BroadcastLiveEvent(
							publishDate = Date(1650460920),
							content = listOf(
								EventContent(
									ContentType.PARAGRAPH,
									"«Алания»: Солдатенко, Шавлохов, Багаев, Гурциев, Хугаев, Хубулов, Засеев, Дав. Кобесов, Бутаев, Хабалов, Хосонов.\n" +
											"Запасные: Богиев, Татаев, Хадарцев, Машуков, Кочиев, Дзахов, Кокоев, Цараев, Сосранов, Григорьев, Дм. Кобесов, Гиоргобиани."
								),
								EventContent(
									ContentType.PARAGRAPH,
									"«Зенит»: Кержаков, Адамов, Алип, Чистяков, Круговой, Барриос, Ерохин, Вендел, Кузяев, Мостовой, Дзюба.\n" +
											"Запасные: Бязров, Кизеев, Сутормин, Сантос, Оздоев, Малком, Ким, Алберто, Сергеев."
								)
							)
						),
						BroadcastLiveEvent(
							publishDate = Date(1650477720),
							content = listOf(
								EventContent(
									ContentType.PARAGRAPH,
									"Встреча «Алания» — «Зенит» состоится в эту среду 20 апреля, на стадионе «имени С. Билимханова» в Грозном. Начало — в 17:00 (мск). Главным арбитром назначен Павел Кукуян. Посмотреть игру в прямом эфире можно на телеканале «Матч! ТВ»."
								),
								EventContent(
									ContentType.PARAGRAPH,
									"«Алания» сумела удивить на прошлой стадии Кубка России, пройдя другого представителя премьер-лиги в лице тульского «Арсенала». Впрочем, команду Божовича сейчас не побеждает только ленивый. После этого успеха подопечные Спартака Гогниев провели восемь матчей ФНЛ в которых четырежды проиграли и четыре раза одержали победы. Нестабильность игры и результатов может явно говорить еще о недостаточном классе команды."
								),
								EventContent(
									ContentType.PARAGRAPH,
									"В свою очередь, «Зенит» традиционно стабилен на внутренней арене. В 2022 календарном году питерцы не проигрывали. После разгрома КАМАЗа со счетом 6:0 в 1/8-й финала питерцы в пяти матчах премьер-лиги одержали три победы и дважды сыграли вничью. Отпраздновали успех подопечные Семака и на последних выходных, уверенно обыграв на своем поле «Урал». Конечно, в гостях «Зенит» не так силен в нынешнем сезоне, как дома, но благодаря значительному превосходству в классе вполне может рассчитывать на уверенную победу в Грозном."
								)
							)
						),
					),
					live = true
				)
			),
			//endregion

        ).toMutableList()
    }

}