# JavaFX Ders Örnekleri - Personel Kayıt

JavaFX derslerinde yazılan örnekler: ilk "merhaba" uygulaması ve FXML ekranlarıyla adım adım geliştirilen
basit bir personel kayıt uygulaması (önce yalnızca ekranlar, sonra JDBC ile MySQL bağlantısı).

> **Not:** Bu depo 2017 yılında eğitim amaçlı yazıldı ve artık güncellenmiyor. Kod yalnızca konuyu anlatmak
> içindir; örneğin SQL sorguları `String.format` ile kurulduğu için SQL enjeksiyonuna açıktır. Üretimde kullanmayın.

## İçerik

| Klasör | Ne yapar |
|---|---|
| `MerhabaFx` | IntelliJ'in JavaFX şablonundan oluşturulan ilk uygulama (`sample.Main`, `sample.fxml`) |
| `PersonelKayit` | FXML ile giriş, başarı, personel ekleme ve görüntüleme ekranları (ekleme ve görüntüleme ekranlarının denetleyicileri henüz boş); giriş kontrolü kod içinde sabit bir kullanıcıyla yapılır. `rsc/` altında kullanım senaryosu (use case) ve veritabanı diyagramları var |
| `PersonelKayitWithJDBC` | Aynı uygulamanın MySQL'e bağlanan sürümü: `ADao`/`PersonelDAO` ile `kullanici` ve `personel` tablolarına giriş kontrolü, listeleme ve ekleme |

Uygulamaların giriş noktası `com.mustafaergan.personelkayit.view.mainlogin.Main` sınıfıdır.

## Teknolojiler

- Java 8 ve JDK ile gelen JavaFX (FXML), IntelliJ IDEA projesi
- `PersonelKayitWithJDBC` için MySQL ve MySQL JDBC sürücüsü (depoda yok, ayrıca eklenmeli)

## Çalıştırma

1. JavaFX içeren bir JDK 8 kullanın ya da daha yeni bir JDK ile ayrıca OpenJFX kurun.
2. Klasörü IntelliJ IDEA'da "New Project from Existing Sources" ile açın ve `src` klasörünü kaynak klasörü olarak
   işaretleyin. `.fxml` dosyaları `src` içindedir ve derleme çıktısına kopyalanmaları gerekir.
3. `mainlogin.Main` sınıfını çalıştırın.
4. `PersonelKayitWithJDBC` için yerelde bir MySQL sunucusunda `personelkayit` veritabanını ve `kullanici`,
   `personel` tablolarını oluşturun (yapı için `PersonelKayit/rsc/db.PNG` ve `PersonelDAO.java` içindeki sorgulara
   bakın), MySQL JDBC sürücüsünü projeye ekleyin ve bağlantı bilgilerini `DAO/ADao.java` içinde kendi
   kurulumunuza göre değiştirin.
