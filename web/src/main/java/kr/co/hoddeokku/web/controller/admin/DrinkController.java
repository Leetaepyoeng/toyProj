package kr.co.hoddeokku.web.controller.admin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.hoddeokku.web.entity.Drink;
import kr.co.hoddeokku.web.service.DrinkService;

@Controller("adminDrinkController")
@RequestMapping("admin/menu/drink")
public class DrinkController {

    @Autowired
    DrinkService service;

    @GetMapping("list")
    public String menuDrinkList(Model model) {
        List<Drink> menus = new ArrayList<>();
        menus = service.getList();
        model.addAttribute("list", menus);

        return "admin/menu/drink/list";
    }

    @GetMapping("reg")
    public String menuDrinkReg() {

        return "admin/menu/drink/reg";
    }

    @GetMapping("edit")
    public String menuHoddukEdit(Model model, @RequestParam("id") Integer id) {
        Drink drink = service.getById(id);
        model.addAttribute("drink", drink);

        return "admin/menu/drink/edit";
    }

    @GetMapping("reg-complete")
    public String menuDrinkRegComplete() {

        return "admin/menu/reg-complete";
    }

    @PostMapping("reg")
    public String registerMenu(
        @RequestParam("korName") String korName,
        @RequestParam("engName") String engName,
        @RequestParam("price") String price,
        @RequestParam("description") String description,
        @RequestParam("imageUpload") List<MultipartFile> imageUpload
    ) throws IOException{
        Drink drink = new Drink();
        drink.setKorName(korName);
        drink.setEngName(engName);
        drink.setPrice(Integer.parseInt(price));
        drink.setDescription(description);

        //경로 설정
        String localFilePath = "C:/Newlec/toyProj/web/src/main/resources/static/image/menu/drink/";
        String dbFilePath = "/image/menu/drink/";

        //일단은 1장만 저장
        for (MultipartFile file : imageUpload) {
            
            localFilePath = "C:/Newlec/toyProj/web/src/main/resources/static/image/menu/drink/";
            //업로드된 이미지 파일명 불러오기
            String fileName = file.getOriginalFilename();
            StringTokenizer st = new StringTokenizer(fileName, "_");
            String newFolderName = st.nextToken();

            //걍 처음은 영문명으로 변경
            newFolderName = engName;

            localFilePath += newFolderName;
            localFilePath += "/";
            String newImgName = st.nextToken();

            //DB용 저장경로는 따로
            dbFilePath += newFolderName;
            dbFilePath += "/";
            dbFilePath += newImgName;
            
            try {
                // 디렉토리 생성
                Path directory = Paths.get(localFilePath);
                Files.createDirectories(directory);

                // 업로드된 파일을 지정된 경로에 저장
                byte[] bytes = file.getBytes();
                Path filePath = Paths.get(localFilePath + newImgName);
                Files.write(filePath, bytes);

                // 파일 저장 성공 시 메시지 출력
                System.out.println("File uploaded successfully: " + fileName);

            } catch (IOException e) {
                // 파일 저장 실패 시 예외 처리
                e.printStackTrace();
                System.err.println("Failed to store file: " + fileName);
            }

        }
        //이미지 경로 저장
        drink.setImg(dbFilePath);
        service.regMenu(drink);

        //이미지 경로 저장
        return "redirect:reg-complete";
    }

    @PostMapping("edit")
    public String editMenu(
        @RequestParam("id") Integer id,
        @RequestParam("imgSrc") String imgSrc,
        @RequestParam("korName") String korName,
        @RequestParam("engName") String engName,
        @RequestParam("price") String price,
        @RequestParam("description") String description,
        @RequestParam("imageUpload") List<MultipartFile> imageUpload
    ) throws IOException{
        Drink drink = new Drink();
        drink.setId(id);
        drink.setKorName(korName);
        drink.setEngName(engName);
        drink.setPrice(Integer.parseInt(price));
        drink.setDescription(description);


        if(!imageUpload.get(0).getOriginalFilename().equals("")){
            //경로 설정
            String localFilePath = "C:/Newlec/toyProj/web/src/main/resources/static/image/menu/drink/";
            String dbFilePath = "/image/menu/drink/";

            //일단은 1장만 저장
            for (MultipartFile file : imageUpload) {
                
                localFilePath = "C:/Newlec/toyProj/web/src/main/resources/static/image/menu/drink/";
                //업로드된 이미지 파일명 불러오기
                String fileName = file.getOriginalFilename();
                StringTokenizer st = new StringTokenizer(fileName, "_");
                String newFolderName = st.nextToken();

                //기존은 이미지를 분해해서 분해한 값으로 저장했는데 그냥 아이디 값으로 폴더 변경
                //즉 처음은 영문명으로 저장하고 두번째부터는 id값으로 저장
                String newEngFolderName = id.toString();

                localFilePath += newEngFolderName;
                localFilePath += "/";
                String newImgName = st.nextToken();
                
                //DB용 저장경로는 따로
                dbFilePath += newEngFolderName;
                dbFilePath += "/";
                dbFilePath += newImgName;

                try {
                    // 디렉토리 생성
                    Path directory = Paths.get(localFilePath);
                    Files.createDirectories(directory);

                    // 업로드된 파일을 지정된 경로에 저장
                    byte[] bytes = file.getBytes();
                    Path filePath = Paths.get(localFilePath + newImgName);
                    Files.write(filePath, bytes);

                    // 파일 저장 성공 시 메시지 출력
                    System.out.println("File uploaded successfully: " + fileName);

                } catch (IOException e) {
                    // 파일 저장 실패 시 예외 처리
                    e.printStackTrace();
                    System.err.println("Failed to store file: " + fileName);
                }

            }
            //이미지 경로 저장
            drink.setImg(dbFilePath);
        }
        else{
            //재수정 이미지를 업로드하지 않을경우 기존값으로
            drink.setImg(imgSrc);
        }
        service.editMenu(drink);


        return "redirect:reg-complete";
    }

    @PostMapping("delete")
    public String menuDrinkDel(@RequestParam("id") String id) {
        service.deleteMenu(Integer.parseInt(id));
        return "redirect:list";
    }
}
