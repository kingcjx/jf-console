package com.atguigu.jf.console.trigger.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.jf.console.baseapi.exchange.ExchangeMapper;
import com.atguigu.jf.console.exchange.bean.bo.ExchangeInfo;
import com.atguigu.jf.console.trigger.service.CreateExcelService;


@Service
public class CreateExcelServiceImpl implements CreateExcelService {
	
	@Autowired
	private ExchangeMapper exchangeMapper;

	@Override
	public String createExcel() throws Exception {
		// 指定生成的文件
		String path = "E:\\excelExport\\";
		// 不存在该文件夹时创建
		File f_path = new File(path);
		if (!f_path.exists()) {
			f_path.mkdirs();
		}
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateFormat = sdf.format(date);
		// 定义文件名
		String fileName = "工作表"+dateFormat + ".xls";
		// 创建工作簿
		Workbook wb = new HSSFWorkbook();
		//CreationHelper createHelper = wb.getCreationHelper();
		// 创建工作表
		Sheet sheet = wb.createSheet("报表");
		// 创建行
		Row Row = sheet.createRow((short) 0);
		List<ExchangeInfo> list = exchangeMapper.selectPcExchangeInfoReport(null);
		//表头信息集合
		List<String> btList = new ArrayList<>();
		btList.add("积分导入流水");
		btList.add("业务发生时间");
		btList.add("积分供应商");
		btList.add("导入积分");
		btList.add("积分兑换比例");
		btList.add("兑换手续费率");
		btList.add("结算金额");
		btList.add("平台利润");
		btList.add("结算状态");
		btList.add("结算日期");
		btList.add("导出状态");
		btList.add("导出时间");
		
	    CellStyle style = wb.createCellStyle();
	    style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
	    style.setFillPattern(CellStyle.BIG_SPOTS);
	    style = wb.createCellStyle();
	    style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
	    style.setFillPattern(CellStyle.SOLID_FOREGROUND);

		//创建表头
		for (int i = 0; i < btList.size(); i++) {
			Cell cell = Row.createCell(i);
			cell.setCellValue(btList.get(i));
			cell.setCellStyle(style);
		}
		//填充数据
		for (int i = 0; i < list.size(); i++) {
			Row rowData = sheet.createRow((short)(i+1));
			ExchangeInfo info = list.get(i);
			List<String> dataList = new ArrayList<>();
			dataList.add(0,info.getId());
			dataList.add(1,info.getImpDate());
			dataList.add(2,info.getProviderName());
			dataList.add(3,info.getImpPoint());
			dataList.add(4,info.getRate());
			dataList.add(5,info.getFee());
			dataList.add(6,info.getAmount());
			dataList.add(7,info.getProfit());
			dataList.add(8,info.getCheckState());
			dataList.add(9,info.getCheckDate());
			dataList.add(10,info.getExportState());
			dataList.add(11,info.getExportDate());
			for(int j = 0;j<btList.size();j++){
				Cell cell = rowData.createCell(j);
				cell.setCellValue(dataList.get(j));
			}
		}
		// 通过row对象创建单元格
		FileOutputStream fileOut = new FileOutputStream(path + fileName);
		wb.write(fileOut);
		fileOut.close();
		String file = path+fileName;
		return file;
	}


}
