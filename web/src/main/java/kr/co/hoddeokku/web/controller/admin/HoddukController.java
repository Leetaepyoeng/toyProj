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

import kr.co.hoddeokku.web.entity.Hodduk;
import kr.co.hoddeokku.web.entity.HoddukView;
import kr.co.hoddeokku.web.service.HoddukService;

@Controller("adminHoddukController")
@RequestMapping("admin/menu/hodduk")
public class HoddukController {

    @Autowired
    HoddukService hoddukService;

    @GetMapping("list")
    public String list(Model model) {
        List<HoddukView> menus = new ArrayList<>();
        Long userId = null;
        menus = hoddukService.getList(userId);
        model.addAttribute("list", menus);
        return "admin/menu/hodduk/list";
    }

    @GetMapping("reg")
    public String menuHoddukReg() {
        return "admin/menu/hodduk/reg";
    }

    @PostMapping("reg")
    public String reg(
        @RequestParam("korName") String korName,
        @RequestParam("engName") String engName,
        @RequestParam("price") String price,
        @RequestParam("description") String description,
        @RequestParam("imageUpload") List<MultipartFile> imageUpload
    ) throws IOException{
        Hodduk hodduk = new Hodduk();
        hodduk.setKorName(korName);
        hodduk.setEngName(engName);
        hodduk.setPrice(Integer.parseInt(price));
        hodduk.setDescription(description);

        //경로 설정
        String localFilePath = "C:/Newlec/toyProj/web/src/main/resources/static/image/menu/hodduk/";
        String dbFilePath = "/image/menu/hodduk/";

        //일단은 1장만 저장
        for (MultipartFile file : imageUpload) {
            
            localFilePath = "C:/Newlec/toyProj/web/src/main/resources/static/image/menu/hodduk/";
            //업로드된 이미지 파일명 불러오기
            String fileName = file.getOriginalFilename();
            StringTokenizer st = new StringTokenizer(fileName, "_");

            //걍 처음은 버립니다. 영문명으로 변경
            String newFolderName = st.nextToken();
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
        hodduk.setImg(dbFilePath);
        hoddukService.regMenu(hodduk);

        //이미지 경로 저장
        return "redirect:reg-complete";
    }

    @GetMapping("reg-complete")
    public String menuHoddukRegComplete() {
        return "admin/menu/reg-complete";
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") Integer id) {
        Hodduk hodduk = hoddukService.getById(id);
        model.addAttribute("hodduk", hodduk);
        return "admin/menu/hodduk/edit";
    }

    @PostMapping("edit")
    public String edit(
        @RequestParam("id") Integer id,
        @RequestParam("imgSrc") String imgSrc,
        @RequestParam("korName") String korName,
        @RequestParam("engName") String engName,
        @RequestParam("price") String price,
        @RequestParam("description") String description,
        @RequestParam("imageUpload") List<MultipartFile> imageUpload
    ) throws IOException{
        Hodduk hodduk = new Hodduk();
        hodduk.setId(id);
        hodduk.setKorName(korName);
        hodduk.setEngName(engName);
        hodduk.setPrice(Integer.parseInt(price));
        hodduk.setDescription(description);


        if(!imageUpload.get(0).getOriginalFilename().equals("")){
            //경로 설정
            String localFilePath = "C:/Newlec/toyProj/web/src/main/resources/static/image/menu/hodduk/";
            String dbFilePath = "/image/menu/hodduk/";

            //일단은 1장만 저장
            for (MultipartFile file : imageUpload) {
                
                localFilePath = "C:/Newlec/toyProj/web/src/main/resources/static/image/menu/hodduk/";
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
            hodduk.setImg(dbFilePath);
        }
        else{
            //재수정 이미지를 업로드하지 않을경우 기존값으로
            hodduk.setImg(imgSrc);
        }
        hoddukService.editMenu(hodduk);


        return "redirect:reg-complete";
    }

    @PostMapping("delete")
    public String menuHoddukDel(@RequestParam("id") String id) {
        hoddukService.deleteMenu(Integer.parseInt(id));
        return "redirect:list";
    }
}
