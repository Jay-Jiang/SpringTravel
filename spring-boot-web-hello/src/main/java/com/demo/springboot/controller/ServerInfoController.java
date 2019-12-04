package com.demo.springboot.controller;

import com.demo.springboot.entities.ResponseMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Properties;

/**
 * @author - Jianghj
 * @since - 2019-12-04 13:47
 * 返回服务器当前信息：包括CPU、内存、硬盘等相关
 */
@Controller
@RequestMapping("/server")
public class ServerInfoController {

	@RequestMapping(value = "/total")
	@ResponseBody
	public ResponseMap serverInfo(HttpServletRequest request) throws IOException {
		//当前系统的概要信息
		Properties systemProperties = System.getProperties();
		//获取当前进程的进程id
		int pid = Integer.parseInt(systemProperties.getProperty("PID"));

		//当前项目运行环境信息
		// Map<String, String> projectEnvironments = System.getenv();

		//进程、cpu、内存等信息
		SystemInfo si = new SystemInfo();
		HardwareAbstractionLayer hal = si.getHardware();
		OperatingSystem os = si.getOperatingSystem();

		//ip 信息
		InetAddress localHost = InetAddress.getLocalHost();
		HashMap<String, Object> ipMap = new HashMap<>(3);
		ipMap.put("ip", request.getLocalAddr());
		ipMap.put("port", request.getLocalPort());
		ipMap.put("host", localHost);

		//jvm 信息
		Runtime jvm = Runtime.getRuntime();
		HashMap<String, Object> jvmMap = new HashMap<>(3);
		jvmMap.put("totalMemory",jvm.totalMemory());
		jvmMap.put("maxMemory",jvm.maxMemory());
		jvmMap.put("freeMemory",jvm.freeMemory());

		return ResponseMap.success()
				.addAttribute("jvm",jvmMap)
				.addAttribute("server", ipMap)
				.addAttribute("operation-system", si.getOperatingSystem())
				// .addAttribute("computer-system",hal.getComputerSystem())
				.addAttribute("cpu",hal.getProcessor())
				.addAttribute("memory",hal.getMemory())
				.addAttribute("current-process",os.getProcess(pid))
				// .addAttribute("processes",os.getProcesses(5, OperatingSystem.ProcessSort.CPU))

				// .addAttribute("sensor",hal.getSensors())
				// .addAttribute("power-source",hal.getPowerSources())
				// .addAttribute("disk",hal.getDiskStores())
				// .addAttribute("net",hal.getNetworkIFs())
				// .addAttribute("displays",hal.getDisplays())
				// .addAttribute("usbDevices",hal.getUsbDevices(true))
				// .addAttribute("net-params",os.getNetworkParams())
				// .addAttribute("file-system",os.getFileSystem())
				// .addAttribute("os",os)
				// .addAttribute("props", systemProperties)
				// .addAttribute("envs", projectEnvironments)
		;
	}


}
