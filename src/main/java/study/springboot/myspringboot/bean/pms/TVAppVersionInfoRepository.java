package study.springboot.myspringboot.bean.pms;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xuefei
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/9/1916:44
 */
public interface TVAppVersionInfoRepository extends JpaRepository<TVAppVersionInfo, Integer> {
    TVAppVersionInfo findFirstByPackageNameAndVersionCodeAAndVersionName(String packageName, int versionCode, String versionName);
}
