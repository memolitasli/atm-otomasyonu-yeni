package Package_atm;
//Mehmet Taþlý
import java.util.Random;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();
		 int s = 0;
		Musteri musteri[] = new Musteri[100]; // 100 adet musteri kaydedebilecegimiz bir musteri dizisi tanýmladým
		int secim,sayac = 0;
		while(true) { /*
		program bir kere çalýþtýktan sonra kullanýcý istemedikten sonra kendini kapatmasýn diye sonsuz döngüye
		alýyorum*/
			System.out.println("Berdus Bank'a hos geldiniz...");
			System.out.println("1->yeni hesap acma");
			System.out.println("2->hesap islemleri");
			System.out.println("3->parolamý unuttum");
			System.out.println("seciminiz : ");
			secim = sc.nextInt();
			switch(secim) {
			case 1:
				int kontrol = 0;
				musteri[sayac] = new Musteri();
				System.out.println("isim : ");
				musteri[sayac].setIsim(sc.next());
				int tempid;
				while(true) {/*her musteriye banka otomatik bir id tahsis ediyor ancak random komutu ile 
				olusturdugum icin ayný numarayi iki veya daha fazla kiþiye verme ihtimali var
				bunu önlemek için tekrardan sonsuz bir döngüye alýyorum ve o numara daha önceden herhangi bir
				kiþiye tahsis edilmiþ mi kontrol ediyorum*/
				tempid = 1+ rnd.nextInt(10000000)*99999999;
				for (int i = 0; i < sayac; i++) {
				if(musteri[i].getId() == tempid)
					kontrol = 1;
				}
				if(kontrol != 1)
					break;
				
				}
				System.out.println("bankamiz tarafindan atanan musteri id'niz : " + tempid);
				musteri[sayac].setId(tempid);
				int temp_parola1,temp_parola2;
				while(true) {
				System.out.println("parolanizi giriniz : ");
				temp_parola1 = sc.nextInt();
				System.out.println("guvenlik için parolanizi lutfen tekrar giriniz : ");
				temp_parola2 = sc.nextInt();
				if(temp_parola1 == temp_parola2)
				{
					System.out.println("parolaniz basarili bir sekilde kaydedildi..");
					musteri[sayac].setParola(temp_parola1);
					break;
				}
				else
				{
					System.out.println("girdiginiz parolalar birbirleriyle uyusmuyor lutfen tekrar deneyin...");
				}
				}
				System.out.println("Telefon numaranizi giriniz : ");
				musteri[sayac].setTelefon(sc.nextLong());
				
				System.out.println("Güvenlik amaci ile asagidaki soruya cevap veriniz... ");
				System.out.println("en sevdiginiz muzisen kimdir :");
				musteri[sayac].setGuvenlik(sc.next());
				System.out.println("hesabýnýz basari ile olusturuldu ana menuye yonlendiriliyorsunuz...");
				
				sayac++;
				break;
				
			case 2:
				int id,parola,indis = -1;
				while(true) {
					System.out.println("Musteri id : ");
					id = sc.nextInt();
					for (int i = 0; i < sayac; i++) {
						if(musteri[i].getId() == id) {
							indis = i;
							break;
						}
					}
					if(indis == -1)
					{
						System.out.println("girdiginiz id ile kayitli bir musteri bulunamadi...");
					}
					else
					{
						break;
					}
				}
				while(true) {
					System.out.println("musteri parolasini giriniz : ");
					parola = sc.nextInt();
					if(musteri[indis].getParola() != parola)
					{
						System.out.println("hatali parola...");
					}
					else {
						System.out.println("basari ile giris yaptiniz...");
						break;
					}
				}
				int a = 1;
				while(a == 1) {
				System.out.println("Sayin "+ musteri[indis].getIsim() + "hoþgeldiniz...");
				System.out.println("1-> hesabýnýza para yatýrma ");
				System.out.println("2->hesabýnýzdan para çekme");
				System.out.println("3->baska bir hesaba para yollama");
				System.out.println("4-> hesap bilgilerim");
				System.out.println("5->çýkýþ");
				int secim2 = sc.nextInt();
				float miktar;
				switch(secim2)
				{
				case 1:
					System.out.print("Yatýrmak istediginiz miktar : ");
					 miktar = sc.nextFloat();
					musteri[indis].setBakiye(musteri[indis].getBakiye() + miktar);
					System.out.println("\n para yatýrma isleminiz basari ile tamamlandi...");
					System.out.println("guncel bakiyeniz : "+musteri[indis].getBakiye());
					break;
				case 2:
					System.out.print("Çekmek istediginiz miktar : ");
					miktar = sc.nextFloat();
					if(miktar > musteri[indis].getBakiye())
					{
						System.out.println("girdiginiz miktar mevcut bakiyenizden daha fazla...");
						break;
					}
					else {
					musteri[indis].setBakiye(musteri[indis].getBakiye() - miktar);
					System.out.println("\n para cekme isleminiz basari ile tamamlandi...");
					System.out.println("guncel bakiyeniz : "+musteri[indis].getBakiye());
					break;
					}
				case 3:
					float giden_id;
					int k  = 0;
					
					System.out.println("gondermek istediginiz kisinin id sini giriniz :");
					giden_id = sc.nextFloat();
					for (int i = 0; i <sayac; i++) {
						if(giden_id == musteri[i].getId())
						{
							s = i;
							k = 1;
							break;
						}
					}
					if(k==1)
					{
						System.out.println("gondermek istediginiz miktari giriniz :");
						miktar = sc.nextFloat();
						if(miktar> musteri[indis].getBakiye())
						{
							System.out.println("mevcut bakiyenizden fazlasýný gonderemezsiniz...");
							break;
						}
						else {
							musteri[indis].setBakiye(musteri[indis].getBakiye() - miktar);
							System.out.println("\n para yollama isleminiz basari ile tamamlandi...");
							System.out.println("guncel bakiyeniz : "+musteri[indis].getBakiye());
							musteri[s].setBakiye(musteri[s].getBakiye() + miktar);
						}
					}
					break;
				case 4:
					System.out.println("isim : " + musteri[indis].getIsim() + " id :" + musteri[indis].getId() +" Telefon numarasi : " + musteri[indis].getTelefon() + " Bakiye : " + musteri[indis].getBakiye());
					break;
				case 5:
					
					System.out.println("çýkýþ yapýlýyor...");
					a = 4;
					break;
				}
				
				}
			case 3:
				System.out.println("Asagidaki islemleri yapiniz...");
				long telefon;
				int inds = -1;
				String cevap;
				System.out.println("Musteri id nizi giriniz : ");
				tempid = sc.nextInt();
				for (int i = 0; i < sayac; i++) {
					if(musteri[i].getId() == tempid)
					{
						inds = i;
						break;
					}
				}
				if(inds == -1)
				{
					System.out.println("girdiginiz id ile kayitli birisi bulunmamaktadir...");
					break;
				}
				else {
					while(true) {
						System.out.println("Telefon numaranizi giriniz: ");
						telefon = sc.nextLong();
						if(telefon == musteri[inds].getTelefon())
						{
							System.out.println("güvenlik sorusuna verdiginiz cevabi giriniz :");
							cevap = sc.next();
							if(cevap.compareTo(musteri[inds].getGuvenlik()) == 0)
							{
								System.out.println("yeni parolanizi giriniz :");
								musteri[inds].setParola(sc.nextInt());
								System.out.println("parola sifirlama islemi basari ile tamamlandi...");
								break;
							}
							else {
								System.out.println("hatali giris yaptiniz...");
								break;
							}
						}
					}
					break;
				}
			
			}
			
		}

	}

}
