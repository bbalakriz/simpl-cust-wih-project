package com.test.cust_wih;
import java.util.HashMap;
import java.util.Map;

import org.jbpm.workflow.instance.WorkflowProcessInstance;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

public class CustomWIH implements WorkItemHandler {

	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		manager.abortWorkItem(workItem.getId());

	}

	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {
		Object param1 = workItem.getParameter("Message");
		Object param2 = workItem.getParameter("KieRuntime");
		
		System.out.println("Do your custom logic here with your param - " + param1);

		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("Result", "Executed CustomWIH successfully");

	    manager.completeWorkItem(workItem.getId(), resultMap);
	}

	class MyClass extends Thread {
		public void run() {
			try {
				System.out.println("Entering into sleep state");
				Thread.sleep(30000L);
			} catch (InterruptedException e) {
				System.out.println("Exception while sleeping..." + e.getMessage());
			}
		}
	}
}