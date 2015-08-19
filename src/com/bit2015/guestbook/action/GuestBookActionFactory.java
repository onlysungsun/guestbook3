package com.bit2015.guestbook.action;

import com.bit2015.web.action.Action;
import com.bit2015.web.action.ActionFactory;

public class GuestBookActionFactory extends ActionFactory {

	public Action getAction(String actionName) {
		Action action = null;
		
		if("insert".equals(actionName)){
			action = new InsertAction();
		}else if("delete".equals(actionName)){
			action = new DeleteAction();
		}else if("deletefrom".equals(actionName)){
			action = new DeleteformAction();
		}else{
			action = new IndexAction();
		}

return action;
	}

}