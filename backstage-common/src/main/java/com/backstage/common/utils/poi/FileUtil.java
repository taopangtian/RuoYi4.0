package com.backstage.common.utils.poi;

import java.io.InputStream;
import java.util.List;

import com.backstage.common.enums.ImportFileType;
import com.backstage.common.utils.JsonUtils;
import com.backstage.common.utils.StringUtils;

public class FileUtil<T> {
	// private static final Logger log =
	// LoggerFactory.getLogger(FileUtil.class);
	/**
	 * 实体对象
	 */
	public Class<T> clazz;

	public FileUtil(Class<T> clazz) {
		this.clazz = clazz;
	}
	public List<T> importFileList(ImportFileType type, InputStream is,String regex)throws Exception {
		List<T> list;
		switch (type) {
		case  PTSSplit:
			list = importPTSSplitFile(is,regex);
			break;

		default:
			list = null;
			break;
		}
		return list;
	}
	
	public T importFile(ImportFileType type, InputStream is) throws Exception {
		T entity;
		switch (type) {
		case POIGeoJSON:
			entity = importPOIGeoJSONFile(is);
			break;
		case CoreJson:
			entity = importPOIGeoJSONFile(is);
			break;
		default:
			entity = null;
			break;
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<T> importPTSSplitFile(InputStream is,String regex) throws Exception{
		List<String[]> rspArr = StringUtils.streamToArrayList(is,regex);
		return (List<T>)rspArr;
	}
	
	public T importPOIGeoJSONFile(InputStream is) throws Exception {
		String rspStr = StringUtils.streamToString(is);
		return JsonUtils.jsonToPojo(rspStr, clazz);
	}
}
