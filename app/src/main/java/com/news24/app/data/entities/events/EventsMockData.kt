package com.news24.app.data.entities.events

import com.news24.app.data.entities.events.model.*
import java.util.*

object EventsMockData {

	fun getItemsList(): MutableList<Event> {
		return listOf(

				Event(
						url = "https://sport24.ru/news/basketball/2022-04-15-uniks-podpisal-amerikanskogo-tsentrovogo-mosli",
						id = "1",
						type = EventType.NEWS,
						publishDate = Date(1650044520),
						data = EventDataNews(
								backgroundImage = "https://s74794.cdn.ngenix.net/api/v1/images/aa4e/256b/bc50/0e85/a78e/1379/4091/322f/1100_10000_max.jpeg", // TODO всегда
								title = "УНИКС подписал американского центрового Мосли",
								sport = "basketball",
								tags = listOf(
										EventTag("1", "https://s74794.cdn.ngenix.net/m/e35c/fe1d/70d8/ddcd/9938/7def/39a6/8805/300_300_max.png") // TODO 300_300_max.png
								),
								image = "https://s74794.cdn.ngenix.net/m/0da4/62c7/8a5c/4c2b/a716/d147/7db6/42ba/1100_10000_max.jpeg",  // TODO 1100_10000_max.jpeg
								content = listOf(
										EventContent(ContentType.PARAGRAPH, "УНИКС на официальном сайте объявил о подписании американского центрового Уильяма Мосли."),
										EventContent(ContentType.PARAGRAPH, "Соглашение между казанским клубом и 32-летним баскетболистом рассчитано до конца сезона-2021/22."),
										EventContent(ContentType.PARAGRAPH, "До перехода в УНИКС Мосли выступал за черногорский «Морнар», где в 19 матчах Адриатической лиги в среднем набирал 6,4 очка и делал 4,8 подбора за игру."),
										EventContent(ContentType.PARAGRAPH, "В прошлом сезоне американец защищал цвета «Партизана».")
								)
						)
				),

				Event(
						url = "https://sport24.ru/news/mma/2022-04-15-sidelnikov-uveren-v-pobede-nemkova-anderson-slabeye-vadima",
						id = "2",
						type = EventType.ARTICLE,
						publishDate = Date(1650043920),
						data = EventDataArticle(
								backgroundImage = "https://s74794.cdn.ngenix.net/api/v1/images/aa4e/256b/bc50/0e85/a78e/1379/4091/322f/1100_10000_max.jpeg", // TODO всегда
								title = "Сидельников сделал прогноз на бой Вадим Немков — Кори Андерсон",
								tags = listOf(
										EventTag("2", "https://s74794.cdn.ngenix.net/m/0a09/7019/83d8/8eaa/4ea1/cb7e/a999/7ee0/300_300_max.png") // TODO 300_300_max.png
								),
								image = "https://s74794.cdn.ngenix.net/m/d47d/6117/6fe7/4a67/b88e/2cb7/0020/c6ee/1100_10000_max.jpeg",  // TODO 1100_10000_max.jpeg
								content = listOf(
										EventContent(ContentType.PARAGRAPH, "Российский боец смешанных единоборств Кирилл Сидельников поделился ожиданиями от боя Вадим Немков — Кори Андерсон. Поединок Немкова c Андерсоном в финале Гран-при Bellator пройдет в ночь 16 апреля мск в Сан-Хосе (штат Калифорния, США)."),
										EventContent(ContentType.HEADER, "Прогноз: победа Немкова за 1.65 (сделать прогноз можно бесплатно, получив до 3 фрибетов по 500 рублей в мобильном приложении БЕТСИТИ)."),
										EventContent(ContentType.PARAGRAPH, "«К этому поединку Вадим начал готовиться очень давно. Дата боя постоянно менялась, хотя об этом никто не объявлял. Сначала говорили, что он состоится в феврале, потом речь шла о марте, а в итоге он был назначен на апрель. И все это время Немков держал себя в форме, тренировался, что довольно непросто на протяжении такого длительного срока. Вадим — большой профессионал. К каждой схватке он подходит в идеальной форме. Его никогда нельзя упрекнуть в отсутствии старания, в желании сачкануть. В этом плане Немков — настоящий чемпион, пахарь."),
										EventContent(ContentType.PARAGRAPH, "Что касается Андерсона, то лично я не считал его сильным соперником. Не думал, что он доберется до финала, ведь в той подгруппе были и более сильные бойцы. Его успех стал для меня неожиданностью. Возможно, немного недооцениваю Андерсона, но лишь из-за уверенности в успехе Немкова. Думаю, Кори ему по зубам. И этот поединок станет для Вадима не самым сложным не только в карьере, но и в рамках Гран-при."),
										EventContent(ContentType.PARAGRAPH, "Когда я узнал имена участников турнира, то наравне с Немковым считал фаворитом Фила Дэвиса. Это очень тягучий, неудобный боец. Плюс Андерсона в том, что он обладает мощным одиночным ударом, способным решить исход схватки. Но Вадим превосходит его во всем — «физике», выносливости, обладает более богатым техническим арсеналом."),
										EventContent(ContentType.PARAGRAPH, "Если брать всех соперников в карьере Немкова, то в пятерку Андерсон входит. Но хоть я и считаю его не таким сильным бойцом, Андерсон все же обладает большим опытом. Он выступал в UFC, дрался с именитыми бойцами. Но, по моему субъективному мнению, он слабее Вадима. Возможно, я просто очень сильно болею за Немкова и желаю ему победы», — цитирует Сидельникова RT."),
										EventContent(ContentType.PARAGRAPH, "Бой Немков — Андерсон ориентировочно начнется в 05:00 по московскому времени."),
										EventContent(ContentType.PARAGRAPH, "Аналитики БЕТСИТИ также склоняются к победе Немкова. На победу Андерсона можно поставить за 2.30.")
								)
						)
				),

				Event(
						url = "https://sport24.ru/photo/figureskating/2022-04-14-shou-eteri-tutberidze-v-moskve-foto-dekolte-medvedevoy-novyy-nomer-trusovoy-zagitova-kvitelashvili-tuktamysheva-kolyada-shcherbakova-fotogalereya",
						id = "3",
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

				Event(
						url = "https://sport24.ru/live/mma/2022-04-08-petr-yan-sterling-chimayev-berns-ufc-273-pryamaya-translyatsiya-smotret-prognoz-foto-video",
						id = "4",
						type = EventType.BROADCAST,
						publishDate = Date(1649566800),
						data = EventDataBroadcast(
								backgroundImage = "https://s74794.cdn.ngenix.net/api/v1/images/aa4e/256b/bc50/0e85/a78e/1379/4091/322f/1100_10000_max.jpeg", // TODO всегда
								title = "Петра Яна засудили в UFC, Чимаев с трудом прошел Бернса, а Олейник финишировал соперника за 3 минуты. Как это было",
								tags = listOf(
										EventTag("3", "https://s74794.cdn.ngenix.net/m/9095/9898/8526/059a/226b/48bd/3965/4c08/300_300_max.png"), // TODO 300_300_max.png
										EventTag("4", "https://s74794.cdn.ngenix.net/m/4141/cf0b/aa59/d75a/feb4/f0a5/60af/808c/300_300_max.png"), // TODO 300_300_max.png
										EventTag("5", "https://s74794.cdn.ngenix.net/m/4259/ae54/1620/4686/ae7c/4f39/eea3/2c4b/300_300_max.png"), // TODO 300_300_max.png
										EventTag("6", "https://s74794.cdn.ngenix.net/m/5546/2c97/90eb/4d23/a27b/ad87/295c/935e/300_300_max.png"), // TODO 300_300_max.png
										EventTag("7", "https://s74794.cdn.ngenix.net/m/3498/26c7/8092/4fae/bf37/8209/d27d/0b02/300_300_max.png"), // TODO 300_300_max.png
										EventTag("8", "https://s74794.cdn.ngenix.net/m/25ea/fae1/eadb/f4f3/7d22/10ea/3fce/9645/300_300_max.png"), // TODO 300_300_max.png
										EventTag("9", "https://s74794.cdn.ngenix.net/m/147d/7a8f/63c1/4421/ea9a/0881/bbdb/74fa/300_300_max.png") // TODO 300_300_max.png
								),
								liveEvents = listOf(
										BroadcastLiveEvent(
												publishDate = Date(1649580000),
												content = listOf(
														EventContent(ContentType.HEADER, "UFC 273 получился довольно-таки сенсационным. Алексей Олейник в свои 44 года одержал яркую победу в первом раунде над Джаредом Вандераа."),
														EventContent(ContentType.PARAGRAPH, "Хамзат Чимаев впервые в карьере провел полный бой, проиграв раунд и получив рассечение. Но это не помешало шведскому чеченцу выиграть у Гилберта Бернса по очкам."),
														EventContent(ContentType.PARAGRAPH, "Самое обидное событие турнира — поражение Петра Яна в реванше со Стерлингом спорным решением судей. Петр посчитал, что забрал первый раунд, поэтому расслабился во втором и третьем, убедительно взяв лишь четвертый и пятый. Но оказалось, что судьи первую пятиминутку отдали Стерлингу."),
														EventContent(ContentType.PARAGRAPH, "Единственный, кто выиграл без вопросов в центральном бою — Александр Волкановски. Зомби неплохо отвечал, но бой все равно смотрелся как одностороннее избиение.")
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649579520),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "Все! Херб Дин остановил бой после очередного жесткого попадания Волкановски. Да, Зомби устоял, но видно было, что он потрясен. Заслуженная и довольно легкая с виду победа чемпиона ТКО в четвертом раунде."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649579400),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "На последних секундах третьего раунда Зомби упал в нокдаун, но не дал себя добить. Если так продолжится, судьи попросту могут остановить избиение."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649579100),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "Второй раунд также в одну калитку забрал Волкановски, которому снова удалось потрясти Зомби. По ударом в голову у австралийца почти трехкратное преимущество."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649578620),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "Бой Волкановски и Зомби пока получается односторонним. Кореец несколько раз был потрясен и, как кажется, проиграл первый раунд со счетом 10-8."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649578200),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "Большинство аналитиков и экспертов также склоняются к победе Стерлинга. Остается надеяться, что в скором времени мы увидим реванш."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649577600),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "«Я считаю, что я выиграл этот бой. Вы меня обокрали! Считаю, что выиграл три раунда из пяти. Джо Роган, я хочу рематч. Я выиграл первый раунд, четвертый и пятый. Я хочу рематч», — сказал Петр Ян в интервью Джо Рогану сразу после боя."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649577360),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "Завершается программа UFC 273 чемпионским боем в полулегком весе. Александр Волкановски сразится с Корейским Зомби. Еще один поединок, в котором, по мнению букмекеров, есть очевидный фаворит. Прошлые два (Ян — Стерлинг, Чимаев — Бернс) оказались крайне конкурентными."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649577060),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "Как же обидно. Дважды 48:47 и 47:48 — победа Стерлинга раздельным решением судей. Довольно странное решение, учитывая, что американец почти не дрался в стойке и за весь бой провел лишь два тейкдауна из 22 попыток."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649576880),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "Конец! Пятый раунд тоже оказался крайне тревожным, вот только теперь Петр не отдавал спину и спокойно разбирал Стерлинга в стойке и однажды встретил коленом. Практически избиение получилось. В концовке Петр умудрился забрать спину и попытался провести удушающий, но времени не хватило."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649576340),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "\n" +
																"Очевидно, что Стерлинг ловит Петра в момент киков, но Петр продолжает их бить и оказывается не в лучших положениях. В очередной попытке Стерлинга забрать спину Ян вырвался и оказался в гарде, работая на очки. Это лучшее решение в ситуации, когда ты проигрываешь."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649576100),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "Третий раунд стал таким же, как и второй. Петр активно поджимал, защитился от нескольких тейкдаунов, но затем прозевал новую попытку и отдал спину, пытаясь встать на ноги. По раундам Стерлинг точно впереди как минимум со счетом 2-1."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649575740),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "Второй раунд оказался на порядок тревожнее. Петр защитился от прохода, но не смог вовремя встать на ноги, а Стерлинг заскочил в фулл-маунт, после чего забрал спину. Вот только Ян в таких положения был крайне часто, особенно в начале своей карьеры, поэтому уверенно отзащищался до конца второго раунда."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649575380),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "Первый раунд позади. Сразу отмечаем, что Стерлинг провел работу над ошибками и теперь работает исключительно вторым номером, не выбрасывая лишние удары. Кроме киков и попытки тейкдауна американец ничем не отметился."),
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
														EventContent(ContentType.PARAGRAPH, "«Я не ожидал, что он такой жесткий парень. Не ожидал. Он вышел сюда и показал бразильский дух. Я знаю бразильцев, они с духом, у меня много братьев бразильцев Мой тренер по БЖЖ бразилец, я знаю его много лет, он мне помогает с первого дня, они жесткие ребята, бразильцы. Я вышел сюда сделать мою работу и забрать мои деньги. Уважение Гилберту, брат, ты показал сердце сегодня. Он был очень хорош сегодня, я не ожидал, что он настолько сильный, не ожидал, что он так начнет. Он должно быть пахал как не знаю кто к этому бою, ведь я сам пахал еще как. Никогда не прекращал свои тренировки. Но он очень жесткий. Я давно хотел такого боя, у меня было 10 побед и 10 финишей, а теперь я окровавлен, я устал, мне больно, но я люблю это», — сказал Чимаев сразу после боя с Бернсом."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649574360),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "Ждем Петра Яна и Алджамейна Стерлинга. Многие знают историю их противостояния. Началось все год назад, когда Петр Ян в одну калитку разбирал Стерлинга, позволив себе запрещенный удар коленом. Победу и пояс отдали американцу. А сейчас долгожданный реванш, который закроет вопрос между бойцами."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649573940),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "Судьи единогласно отдают победу Чимаеву. Да, крайне тяжелый бой получился для Хамзата. В интервью Джо Рогану Хамзат признал мощь Бернса и сказал, что не ожидал такого трудного поединка."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649573460),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "Первый третий раунд Чимаева в UFC. И сразу же Хамзат зажал Бернса у сетки и старается финишировать в стойке. Но не удается — бразилец здорово держит удар, а в концовке даже взрывается серией, на которую Чимаев не ответил. Бразилец выдержал испытание, а шведский чеченец, скорее всего, нет. Ждем судейское решение."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649573220),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "Слишком часто пропускает Чимаев во втором раунде. Много разменов, в которых Бернс смотрится все увереннее и увереннее. Стоит отметить, что Хамзат не идет в борьбу, но хорошо защищается. И снова пропускает навстречу Чимаев, но в последний момент собирается и оформляет тейкдаун."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649572800),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "Поднялись бойцы в стойку. Несколько разменов в стойке! Первые удары пропустил Чимаев в UFC. Роняет Бернса джебом! Но добить не удается, спасается бразилец, и раунд заканчивается."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649572740),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "Поехали! И Хамзат сразу же давит Бернса к сетке и идет в борьбу, но завалить бразильца с первой попытки не удалось. Но затем все же перевел!"),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649571840),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "Дождались! Совсем скоро на арене появятся Хамзат Чимаев и Гилберт Бернс. Самый интригующий бой UFC 273, который может оказаться самым односторонним. Посмотрим."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649571600),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "Крайне тяжелый бой для судейства. 29:28, 28:29 и 29:28 — победа Маккензи Дерн раздельным решением. В чем-то справедливое решение, ведь именно Дерн работала первым номером и угрожала сабмишенами, тогда как Торрес бегала по клетке и отбивалась в стиле Джона Джонса киками."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649569800),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "Впереди бой девушек. Маккензи Дерн — титулованная представительница бразильского джиу-джитсу. Тиша Торрес — ветеран UFC, идущая на серии из трех побед. Будет интересно."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649569680),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "Марк Мадсен одержал уверенную победу единогласным решением судей (дважды 30:27 и 29:28). Интересный боец, но говорить о топ-уровне сложно. Даже 39-летний Пичел неплохо смотрелся на фоне олимпийского призера."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649568060),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "До боя Хамзата Чимаева и Гилберта Бернса остается около часа. Прямо сейчас в клетке сойдутся 39-летний ударник Винс Пичел и 37-летний обладатель серебряной медали Рио по греко-римской борьбе Марк Мадсен."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649567460),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "Перемещаемся в Джексонвилль, где совсем скоро начнется основной кард турнира UFC 273. Несколько часов назад ярчайшей победой отметился легендарный Алексей Олейник. Харьковчанин уверенно разобрал Джареда Вандераа за 3,5 минуты, оформив 47-ю победу сабмишеном в карьере."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649592000),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "Битвы взглядов получились максимально горячими."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649613000),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "Накануне прошла официальная церемония взвешивания. Все участники главных боев вечера сделали вес."),
												)
										),
										BroadcastLiveEvent(
												publishDate = Date(1649548800),
												content = listOf(
														EventContent(ContentType.PARAGRAPH, "В ночь на 10 апреля в Джексонвилле состоится турнир UFC 273. Бои Петра Яна и Хамзата Чимаева стоят особняком в сравнении с остальными поединками карда. Обладатель временного титула UFC из России поставит жирную точку в отношениях с Алджамейном Стерлингом, годом ранее завоевавшим пояс благодаря дисквалификации Петра. Чимаева ждет настоящая, как думают эксперты, проверка в лице бывшего претендента на титул Гилберта Бернса."),
														EventContent(ContentType.PARAGRAPH, "Также не обойдем стороной главный бой мейн-карда: Александр Волкановски зарубится с Корейским Зомби. Впереди много интересного и захватывающего. Начинаем следить за самыми жаркими событиями с 06:00 по московскому времени."),
														)
										)
								),
								live = true
						)
				)



		).toMutableList()
	}


}