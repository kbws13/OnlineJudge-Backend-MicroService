package xyz.kbws.controller;

import cn.hutool.core.date.DateTime;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import xyz.kbws.manager.CosManager;
import xyz.kbws.ojbackendcommon.common.BaseResponse;
import xyz.kbws.ojbackendcommon.common.ErrorCode;
import xyz.kbws.ojbackendcommon.common.ResultUtils;
import xyz.kbws.ojbackendcommon.constant.FileConstant;
import xyz.kbws.ojbackendcommon.exception.BusinessException;

import javax.annotation.Resource;
import java.io.File;

/**
 * @author kbws
 * @date 2024/2/27
 * @description:
 */
@Api(tags = "文件接口")
@RestController
@RequestMapping("/")
@Slf4j
public class FileController {

    @Resource
    private CosManager cosManager;

    @ApiOperation(value = "上传头像")
    @PostMapping("/upload")
    public BaseResponse<String> uploadCosFile(@RequestPart("file") MultipartFile multipartFile) {
        //获取上传的文件
        if (multipartFile.isEmpty()) {
            throw new BusinessException(ErrorCode.NULL_ERROR, "上传文件为空");
        }
        // 文件目录：根据业务、用户来划分
        String uuid = RandomStringUtils.randomAlphanumeric(8);
        String filename = uuid + "-" + multipartFile.getOriginalFilename();
        String datePath = new DateTime().toString("yyyy-MM-dd");
        String filepath = String.format("/%s/%s", datePath, filename);
        File file = null;
        try {
            // 上传文件
            file = File.createTempFile(filepath, null);
            multipartFile.transferTo(file);
            cosManager.putObject(filepath, file);
            // 返回可访问地址
            return ResultUtils.success(FileConstant.COS_HOST + filepath);
        } catch (Exception e) {
            log.error("file upload error, filepath = " + filepath, e);
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "上传失败");
        } finally {
            if (file != null) {
                // 删除临时文件
                boolean delete = file.delete();
                if (!delete) {
                    log.error("file delete error, filepath = {}", filepath);
                }
            }
        }
    }

}
