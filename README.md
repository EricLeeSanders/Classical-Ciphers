# Classical-Ciphers
#### Classical Ciphers written in Java using Swing for GUI

This was a midterm project for my cryptography class at Butler. We had to implement an encryption and decryption for a Shift, Affine, Substitution, and Vigenere Cipher. I went a levels beyond and also implements auto decryption for Shift and Vigenere Cipher. The auto decryption will automatically decrypt an encrypted text and give the shift or key that was used to encrypt the text. I also added a GUI rather than using a simple command prompt.

I decided to use Java for this project because I was familiar with Swing. This allowed me to quickly create a GUI.

I plan to add a web front end for ths app in the near future and may add/improve auto decryptions.


### Shift
The program can encrypt, decrypt, and auto decrypt.
It auto decrypts using frequency analysis to determine the similarity between each shift and the English   language.
Sample output with a shift of 19:
##### Plain Text
Prepare the forces. We attack at midnight.
##### Encrypted
IKXITKXMAXYHKVXLPXTMMTVDTMFBWGBZAM

##### Auto Decryption Ouput

Doing an automatic shift decryption...  
Frequency 19) 0.13021523512430297 Difference w/ English  
Frequency 8) 0.20735336800540133 Difference w/ English  
Frequency 4) 0.23433411626716413 Difference w/ English  
Frequency 15) 0.23839563344724415 Difference w/ English  
Frequency 23) 0.2476242560097049 Difference w/ English  
Frequency 6) 0.2528138267340006 Difference w/ English  
Frequency 5) 0.25345983865578925 Difference w/ English  
Frequency 12) 0.2546210710279467 Difference w/ English  
Frequency 21) 0.27341867559543154 Difference w/ English  
Frequency 20) 0.2793861050477844 Difference w/ English  
Frequency 10) 0.280091594975866 Difference w/ English  
Frequency 17) 0.28071045651997717 Difference w/ English  
Frequency 18) 0.2821797640214184 Difference w/ English  
Frequency 1) 0.2822360429304977 Difference w/ English  
Frequency 7) 0.2831474493028549 Difference w/ English  
Frequency 16) 0.2861480619204514 Difference w/ English  
Frequency 25) 0.28639566694821483 Difference w/ English  
Frequency 9) 0.2886471616508046 Difference w/ English  
Frequency 2) 0.29277999437382385 Difference w/ English  
Frequency 26) 0.2939840058468685 Difference w/ English  
Frequency 11) 0.3003549005460156 Difference w/ English  
Frequency 24) 0.3006309176298208 Difference w/ English  
Frequency 3) 0.301133361778672 Difference w/ English  
Frequency 22) 0.3022428052755441 Difference w/ English  
Frequency 14) 0.3058817655848433 Difference w/ English  
Frequency 13) 0.31779313719259705 Difference w/ English  
The best choice to shift is: 19  
Doing a shift decryption...  
Shift decryption complete!  
PREPARETHEFORCESWEATTACKATMIDNIGHT  


### Keyword Columnar Transposition Substitution
The program can encrypt and decrypt using keyword columnar trapsosition substitution cipher. 
Sample of output with keyword: SPY
##### Plain Text
They don't know that I'm spying on them.
##### Encrypted
CUJTGNKCBKNLCUSCXHYRTXKQNKCUJH

Doing a substitution encryption...
Substitution Alphabet: SADGJMQUXPBEHKNRVZYCFILOTW
Substitution encryption complete!


### Affine 
The program can encrypt and decrypt using affine cipher.
Sample of output with A:11, B:5
##### Plain Text
What's the wifi password?
##### Encrypted
NEFGVGEXNPIPOFVVNDKM


### Vigenere
The program can encrypt, decrypt, and auto decrypt using vigenere cipher.
Auto decryption uses the Friedman Test as well as the Kasiski Test to deteremine the keyword length.
Then using frequency analysis from the shift cipher, we find the best match to the English   language for each coset.

Sample ouput with the text: LINCOLN
##### Plain Text
Four score and seven years ago our fathers brought forth on this continent, a new nation, conceived in Liberty, and dedicated to the proposition that all men are created equal.

Now we are engaged in a great civil war, testing whether that nation, or any nation so conceived and so dedicated, can long endure. We are met on a great battle-field of that war. We have come to dedicate a portion of that field, as a final resting place for those who here gave their lives that that nation might live. It is altogether fitting and proper that we should do this.

But, in a larger sense, we can not dedicate -- we can not consecrate -- we can not hallow -- this ground. The brave men, living and dead, who struggled here, have consecrated it, far above our poor power to add or detract. The world will little note, nor long remember what we say here, but it can never forget what they did here. It is for us the living, rather, to be dedicated here to the unfinished work which they who fought here have thus far so nobly advanced. It is rather for us to be here dedicated to the great task remaining before us -- that from these honored dead we take increased devotion to that cause for which they gave the last full measure of devotion -- that we here highly resolve that these dead shall not have died in vain -- that this nation, under God, shall have a new birth of freedom -- and that government of the people, by the people, for the people, shall not perish from the earth.


##### Encrypted
QWHTGNBCMNPRDRGMAASLEDITQCFEQIGJSCFMZBWUSGQWEVVZAEPVUQZAEQAGBENYMJPOEVZVPQBNRTDRFWYYTJRTHJNYLQGRTPLBRFHZGSMCTCABDQGKCYGSIGCZWZPVNTSNEPIGGRPDFIYPCHJPIEGSYTLORFWYNRZRCHNVGQYYOCGPAGKBRJSMGJSCGSIGPOEVZVBTOYLYIGKCYFZKBPQPVGMQCBOFZLRFWNNEMQEOYYZVTGBOHCMJGOCRXMGQBLTCMNVPLGETRHWPYOWSVVLGHIEYSSNGMPQAPGZLRFWNNEMNRCCGTWAQTEULBSKSWQLANHWYNWZRUHTARXYCQPSZZGJCDRHPBJSCRRIIGHSRTZYKJPFEPNVHSNEVNVWZAXQTJHWVGMVVWDNWBBISEUPZSKHEVYONPRAEZXRTHSNEERUVZHWLQQHSVDJHVWYNWIEISCFPVFGKPPLVAQHOROQPCHPJPKNPBZGNWAUSNELBRYSNNYVBVVLYWWJVVTFRZBWBOGSMOTOGRXMANWGVYONPRORLLJJCDGCCTIZPQSMEGVLIPKBPGPPCIGGRTGQIECPZIPWHTDZBCXBYSCGZIQFCCQPBECQEGSMJQFWQHQYNZTGETRPCERYWENCYTCMZGAMRCEUCHHRDILJSCRMCGKHNNYVRXSCSZZTGHHULBGJSJQTLUGFPVEQFHCCHDBUGZTITVTTOEUPZGQPPQPLVEOEROPRTSEBEPRWBQVYQFJSOJZZXYVTPSBUGMHUZNBWUSGSMEGVLIPBUWGQNCABPCMYJIQXOYPPLVVWDELBUGFQBCCFVCMRSMEGRPQTKNVSOGZBUGUCRLBGCGVEPUNKBTARJRHCCRFAGJOESCWZVVPFPPBPCCROLRCRHREIXGWYPCMNUSOQPDBVWZAEWGJOEPLCFGTZEHPVEVEUPGTCJPGSMYCGESFTYOSLFFZRQTORGWGKCYGSIGYSSRCMUKUSYJZRUCWIPBUCHEUPARFSLQDPNNZYBEPNXSOVPLVPJLVYBUCHEUTAACHTBYCAFSCTZLFJOWYSIIGOYRHJVTHSBQNEGSOBXIAFHSNEOBXSCAXMAVCQGSMCGCAYPJLVVPCPWCNSQBCBUGDPBATRUVLYWVBVDPETAUHFZZEPRGOCGS

##### Auto Decryption Output
Doing a vigenere automatic decryption...  
Doing a vigenere auto decryption w/ Friedman...  
Calculating the Index of Coincidence...  
Sum = 57756.0  
Denominator = 1319052.0  
IC = 0.043785991757716906  
Friedman test complete!  
Friedman estimated Key length= 4.99580091037394  
Friedman guess for the keyword length is = 4.99580091037394  
Doing a vigenere auto decryption w/ Kasiski...  
min = 7  
Factors = [1, 7]  
Kasiski test complete!  
Kasiski guess for a possible keyword length is = 1  
Kasiski guess for a possible keyword length is = 7  
The Smallest distance is between Friendman Key and Kasiski Key at: 7 = 2.00419908962606  
Estimated key length = 7  
Doing an automatic shift decryption...  
Frequency 11) 0.07133584194952984 Difference w/ English  
Frequency 24) 0.2084106143286136 Difference w/ English  
Frequency 15) 0.2177637361244767 Difference w/ English  
Frequency 26) 0.23001439200290597 Difference w/ English  
Frequency 22) 0.23303156747006915 Difference w/ English  
Frequency 4) 0.2334314822214494 Difference w/ English  
Frequency 7) 0.2363512074344855 Difference w/ English  
Frequency 25) 0.24106194837159373 Difference w/ English  
Frequency 14) 0.24202995541119549 Difference w/ English  
Frequency 10) 0.24624910259423582 Difference w/ English  
Frequency 12) 0.24664110089293434 Difference w/ English  
Frequency 18) 0.24734949372015702 Difference w/ English  
Frequency 23) 0.24832081384586463 Difference w/ English  
Frequency 1) 0.2516661134314245 Difference w/ English  
Frequency 2) 0.2530817616981201 Difference w/ English  
Frequency 17) 0.25770516848095965 Difference w/ English  
Frequency 21) 0.25810019650817273 Difference w/ English  
Frequency 5) 0.26408621626161327 Difference w/ English  
Frequency 20) 0.2663091435200937 Difference w/ English  
Frequency 8) 0.26716936391232243 Difference w/ English  
Frequency 13) 0.2677655282224059 Difference w/ English  
Frequency 6) 0.26777865562298714 Difference w/ English  
Frequency 19) 0.2692489260235407 Difference w/ English  
Frequency 3) 0.2693315225021293 Difference w/ English  
Frequency 16) 0.2724927843047655 Difference w/ English  
Frequency 9) 0.28179804058932284 Difference w/ English  
The best choice to shift is: 11  
Shift Amount for 0 = 11  

Doing an automatic shift decryption...  
Frequency 8) 0.07250830988705348 Difference w/ English  
Frequency 4) 0.2118067259296041 Difference w/ English  
Frequency 21) 0.21956640503999963 Difference w/ English  
Frequency 23) 0.2299289739277272 Difference w/ English  
Frequency 19) 0.23322163932932435 Difference w/ English  
Frequency 20) 0.24624723126385803 Difference w/ English  
Frequency 7) 0.2501360924752254 Difference w/ English  
Frequency 12) 0.25128817657343894 Difference w/ English  
Frequency 1) 0.25634607206121485 Difference w/ English  
Frequency 24) 0.25846430404620985 Difference w/ English  
Frequency 15) 0.259888139872868 Difference w/ English  
Frequency 18) 0.2622912947380448 Difference w/ English  
Frequency 9) 0.26254224538621035 Difference w/ English  
Frequency 22) 0.2659513826425917 Difference w/ English  
Frequency 17) 0.26802237143201835 Difference w/ English  
Frequency 5) 0.26815019704152504 Difference w/ English  
Frequency 14) 0.2738176647684775 Difference w/ English  
Frequency 11) 0.27389336785306884 Difference w/ English  
Frequency 25) 0.27909023172031905 Difference w/ English  
Frequency 16) 0.2814958152922832 Difference w/ English  
Frequency 3) 0.2816753301019506 Difference w/ English  
Frequency 10) 0.28356874914292274 Difference w/ English  
Frequency 26) 0.2840536558344583 Difference w/ English  
Frequency 2) 0.2862742440520192 Difference w/ English  
Frequency 6) 0.2899842575672399 Difference w/ English  
Frequency 13) 0.2978373535153347 Difference w/ English  
The best choice to shift is: 8  
Shift Amount for 1 = 8  

Doing an automatic shift decryption...  
Frequency 13) 0.06293510939804178 Difference w/ English  
Frequency 9) 0.2180741062112179 Difference w/ English  
Frequency 2) 0.2182012914826573 Difference w/ English  
Frequency 24) 0.21891550590730388 Difference w/ English  
Frequency 26) 0.22449341061505043 Difference w/ English  
Frequency 6) 0.23595984299693584 Difference w/ English  
Frequency 17) 0.23752658119762363 Difference w/ English  
Frequency 20) 0.24787850819345303 Difference w/ English  
Frequency 25) 0.24791269843177452 Difference w/ English  
Frequency 19) 0.2517186751307452 Difference w/ English  
Frequency 1) 0.25199660991683526 Difference w/ English  
Frequency 12) 0.25209579807997123 Difference w/ English  
Frequency 14) 0.25709559519391656 Difference w/ English  
Frequency 16) 0.25736985571175547 Difference w/ English  
Frequency 23) 0.2582707006693012 Difference w/ English  
Frequency 3) 0.26132443846928083 Difference w/ English  
Frequency 15) 0.2644651273886589 Difference w/ English  
Frequency 5) 0.2647213881816072 Difference w/ English  
Frequency 10) 0.2669061197789052 Difference w/ English  
Frequency 4) 0.2703378170216233 Difference w/ English  
Frequency 22) 0.2724347739252902 Difference w/ English  
Frequency 8) 0.2752009885383853 Difference w/ English  
Frequency 21) 0.27717516464752484 Difference w/ English  
Frequency 7) 0.27888667808709633 Difference w/ English  
Frequency 18) 0.2814760288625157 Difference w/ English  
Frequency 11) 0.28268697450699615 Difference w/ English  
The best choice to shift is: 13  
Shift Amount for 2 = 13  

Doing an automatic shift decryption...  
Frequency 2) 0.06379520820428039 Difference w/ English  
Frequency 17) 0.22521658801397546 Difference w/ English  
Frequency 24) 0.22585166577045848 Difference w/ English  
Frequency 15) 0.2279392287528885 Difference w/ English  
Frequency 13) 0.23173933907033198 Difference w/ English  
Frequency 6) 0.23525818573575955 Difference w/ English  
Frequency 14) 0.2501376680551559 Difference w/ English  
Frequency 1) 0.2533022378736096 Difference w/ English  
Frequency 18) 0.2541083393004303 Difference w/ English  
Frequency 21) 0.255838791285475 Difference w/ English  
Frequency 3) 0.26002054197382957 Difference w/ English  
Frequency 5) 0.26269234403426706 Difference w/ English  
Frequency 9) 0.26417256796079 Difference w/ English  
Frequency 19) 0.26459001751826405 Difference w/ English  
Frequency 16) 0.26523726020222643 Difference w/ English  
Frequency 11) 0.27127714980156664 Difference w/ English  
Frequency 20) 0.27385629007605017 Difference w/ English  
Frequency 12) 0.27402145065504596 Difference w/ English  
Frequency 8) 0.27408819891587716 Difference w/ English  
Frequency 4) 0.27865040481223524 Difference w/ English  
Frequency 22) 0.28078344108039816 Difference w/ English  
Frequency 25) 0.28182410931257723 Difference w/ English  
Frequency 7) 0.2829572911056145 Difference w/ English  
Frequency 23) 0.283362560662042 Difference w/ English  
Frequency 10) 0.2850985269222591 Difference w/ English  
Frequency 26) 0.29703814209309914 Difference w/ English  
The best choice to shift is: 2  
Shift Amount for 3 = 2  

Doing an automatic shift decryption...  
Frequency 14) 0.09763238806962814 Difference w/ English  
Frequency 25) 0.24473830778555986 Difference w/ English  
Frequency 10) 0.24475275783629313 Difference w/ English  
Frequency 3) 0.24535168443244282 Difference w/ English  
Frequency 18) 0.26326354277847897 Difference w/ English  
Frequency 15) 0.2690634348637256 Difference w/ English  
Frequency 7) 0.27165618564681804 Difference w/ English  
Frequency 26) 0.27224004880948033 Difference w/ English  
Frequency 1) 0.27466744465152393 Difference w/ English  
Frequency 24) 0.27980243078527606 Difference w/ English  
Frequency 11) 0.28032408993038826 Difference w/ English  
Frequency 4) 0.28101798446082127 Difference w/ English  
Frequency 21) 0.28139874543410065 Difference w/ English  
Frequency 2) 0.28372502194594545 Difference w/ English  
Frequency 9) 0.28644160053534756 Difference w/ English  
Frequency 13) 0.2872179596942193 Difference w/ English  
Frequency 20) 0.2897271808059082 Difference w/ English  
Frequency 22) 0.2950694590078798 Difference w/ English  
Frequency 16) 0.29974258920871477 Difference w/ English  
Frequency 5) 0.30204669366076164 Difference w/ English  
Frequency 17) 0.30307752414061134 Difference w/ English  
Frequency 8) 0.3032476815590025 Difference w/ English  
Frequency 6) 0.3099510351261764 Difference w/ English  
Frequency 23) 0.3103721374221329 Difference w/ English  
Frequency 19) 0.3145292809358647 Difference w/ English  
Frequency 12) 0.32592702352458147 Difference w/ English  
The best choice to shift is: 14  
Shift Amount for 4 = 14  

Doing an automatic shift decryption...  
Frequency 11) 0.08902341081820067 Difference w/ English  
Frequency 26) 0.20645302274497074 Difference w/ English  
Frequency 24) 0.21129201124313607 Difference w/ English  
Frequency 22) 0.21660585057420406 Difference w/ English  
Frequency 7) 0.2264305134689309 Difference w/ English  
Frequency 10) 0.22865576825576245 Difference w/ English  
Frequency 20) 0.23617309044282728 Difference w/ English  
Frequency 15) 0.23817532354733323 Difference w/ English  
Frequency 21) 0.2391018190412362 Difference w/ English  
Frequency 14) 0.24813484112680181 Difference w/ English  
Frequency 25) 0.24837775491601652 Difference w/ English  
Frequency 2) 0.25305219140751406 Difference w/ English  
Frequency 4) 0.25455182397370535 Difference w/ English  
Frequency 23) 0.25759141756940085 Difference w/ English  
Frequency 12) 0.25797673721093306 Difference w/ English  
Frequency 9) 0.25976593003204523 Difference w/ English  
Frequency 18) 0.2602736306191185 Difference w/ English  
Frequency 6) 0.26054548194415306 Difference w/ English  
Frequency 1) 0.26128327187462846 Difference w/ English  
Frequency 17) 0.2638879970570456 Difference w/ English  
Frequency 8) 0.2646482651729877 Difference w/ English  
Frequency 5) 0.2656102901061845 Difference w/ English  
Frequency 13) 0.26994610458575463 Difference w/ English  
Frequency 16) 0.2704761778709122 Difference w/ English  
Frequency 3) 0.2810978856772898 Difference w/ English  
Frequency 19) 0.2811722792178052 Difference w/ English  
The best choice to shift is: 11  
Shift Amount for 5 = 11  

Doing an automatic shift decryption...  
Frequency 13) 0.07114146182376609 Difference w/ English    
Frequency 2) 0.19903642338608482 Difference w/ English  
Frequency 24) 0.2164241212835325 Difference w/ English  
Frequency 17) 0.22423639590610386 Difference w/ English  
Frequency 9) 0.2370054754542612 Difference w/ English  
Frequency 26) 0.24101337940835776 Difference w/ English  
Frequency 25) 0.24434134516343323 Difference w/ English  
Frequency 6) 0.2470847297749971 Difference w/ English  
Frequency 20) 0.2524156662452474 Difference w/ English  
Frequency 14) 0.2528136984560127 Difference w/ English  
Frequency 12) 0.25320990093573703 Difference w/ English  
Frequency 3) 0.25361413994623067 Difference w/ English  
Frequency 1) 0.2553882940957829 Difference w/ English  
Frequency 4) 0.26035695062118824 Difference w/ English  
Frequency 5) 0.2650011694041073 Difference w/ English  
Frequency 23) 0.26580138427612693 Difference w/ English  
Frequency 15) 0.2662215477163168 Difference w/ English  
Frequency 19) 0.26678759301276417 Difference w/ English  
Frequency 10) 0.2675911247209944 Difference w/ English  
Frequency 21) 0.2677801888520543 Difference w/ English  
Frequency 16) 0.26878295764822907 Difference w/ English  
Frequency 8) 0.27331057163240524 Difference w/ English  
Frequency 22) 0.27859514341044384 Difference w/ English  
Frequency 18) 0.2791612180070915 Difference w/ English  
Frequency 11) 0.27988653673244257 Difference w/ English  
Frequency 7) 0.28076400172314314 Difference w/ English  
The best choice to shift is: 13  
Shift Amount for 6 = 13  
Key = LINCOLN  
Doing a vigenere decryption...  
Vigenere decryption complete!  
FOURSCOREANDSEVENYEARSAGOOURFATHERSBROUGHTFORTHONTHISCONTINENTANEWNATIONCONCEIVEDINLIBERTYANDDEDICATEDTOTHEPROPOSITIONTHATALLMENARECREATEDEQUALNOWWEAREENGAGEDINAGREATCIVILWARTESTINGWHETHERTHATNATIONORANYNATIONSOCONCEIVEDANDSODEDICATEDCANLONGENDUREWEAREMETONAGREATBATTLEFIELDOFTHATWARWEHAVECOMETODEDICATEAPORTIONOFTHATFIELDASAFINALRESTINGPLACEFORTHOSEWHOHEREGAVETHEIRLIVESTHATTHATNATIONMIGHTLIVEITISALTOGETHERFITTINGANDPROPERTHATWESHOULDDOTHISBUTINALARGERSENSEWECANNOTDEDICATEWECANNOTCONSECRATEWECANNOTHALLOWTHISGROUNDTHEBRAVEMENLIVINGANDDEADWHOSTRUGGLEDHEREHAVECONSECRATEDITFARABOVEOURPOORPOWERTOADDORDETRACTTHEWORLDWILLLITTLENOTENORLONGREMEMBERWHATWESAYHEREBUTITCANNEVERFORGETWHATTHEYDIDHEREITISFORUSTHELIVINGRATHERTOBEDEDICATEDHERETOTHEUNFINISHEDWORKWHICHTHEYWHOFOUGHTHEREHAVETHUSFARSONOBLYADVANCEDITISRATHERFORUSTOBEHEREDEDICATEDTOTHEGREATTASKREMAININGBEFOREUSTHATFROMTHESEHONOREDDEADWETAKEINCREASEDDEVOTIONTOTHATCAUSEFORWHICHTHEYGAVETHELASTFULLMEASUREOFDEVOTIONTHATWEHEREHIGHLYRESOLVETHATTHESEDEADSHALLNOTHAVEDIEDINVAINTHATTHISNATIONUNDERGODSHALLHAVEANEWBIRTHOFFREEDOMANDTHATGOVERNMENTOFTHEPEOPLEBYTHEPEOPLEFORTHEPEOPLESHALLNOTPERISHFROMTHEEARTH  

