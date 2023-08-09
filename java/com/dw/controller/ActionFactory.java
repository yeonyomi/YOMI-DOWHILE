package com.dw.controller;

import com.dw.controller.action.AboutAction;
import com.dw.controller.action.Action;
import com.dw.controller.action.AdminAction;
import com.dw.controller.action.DeleteMypageUser;
import com.dw.controller.action.DeleteUserAction;
import com.dw.controller.action.DongSelectAction;
import com.dw.controller.action.GymSelectAction;
import com.dw.controller.action.IdCheckAction;
import com.dw.controller.action.InsertSpecAction;
import com.dw.controller.action.JoinAction;
import com.dw.controller.action.JoinFormAction;
import com.dw.controller.action.LoginAction;
import com.dw.controller.action.LoginFormAction;
import com.dw.controller.action.LogoutAction;
import com.dw.controller.action.MainAction;
import com.dw.controller.action.ManageUserAction;
import com.dw.controller.action.MyPageAction;
import com.dw.controller.action.PlaceAction;
import com.dw.controller.action.PlaceSelectAction;
import com.dw.controller.action.ScheduleAction;
import com.dw.controller.action.ShopAction;
import com.dw.controller.action.UpdateMypageUser;
import com.dw.controller.action.UpdateUserAction;
import com.dw.controller.action.UserChangeAction;
import com.dw.controller.action.UserShopAction;
import com.dw.controller.action.UserSpecAction;
import com.dw.controller.action.UserViewAction;
import com.dw.controller.action2.ManageProductAction;
import com.dw.controller.action2.ProductDeleteAction;
import com.dw.controller.action2.ProductRegistrationAction;
import com.dw.controller.action2.ProductRegistrationFormAction;
import com.dw.controller.action2.ProductUpdateAction;
import com.dw.controller.action2.ProductViewAction;
import com.dw.controller.action2.SearchAction;
import com.dw.controller.action3.ExerciseRecommend;
import com.dw.controller.action3.TrainingAction;
import com.dw.controller.action4.MealplanDeleteAction;
import com.dw.controller.action4.MealplanViewAction;
import com.dw.controller.action4.MealplanWriteAction;
import com.dw.controller.action4.MealplanWriteFormAction;
import com.dw.controller.action4.WorkoutDeleteAction;
import com.dw.controller.action4.WorkoutListAction;
import com.dw.controller.action4.WorkoutUpdateAction;
import com.dw.controller.action4.WorkoutViewAction;
import com.dw.controller.action4.WorkoutWriteAction;
import com.dw.controller.action4.WorkoutWriteFormAction;
import com.dw.controller.action5.CartBasketAction;
import com.dw.controller.action5.CartDeleteAction;
import com.dw.controller.action5.CartDeleteAllAction;
import com.dw.controller.action5.CartInsertAction;
import com.dw.controller.action5.CartListAction;
import com.dw.controller.action5.CartPayAction;
import com.dw.controller.action5.CartUpdateAction;
import com.dw.controller.action5.CartViewAction;
import com.dw.controller.action6.MallMainAction;
import com.dw.controller.action6.ProductDetailAction;
import com.dw.controller.action6.ProductListAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {

		Action action = null;

		// 로그인, 회원가입, 관리자
		if (command.equals("main")) {
			action = new MainAction();
		} else if (command.equals("login_form")) {
			action = new LoginFormAction();
		} else if (command.equals("login")) {
			action = new LoginAction();
		} else if (command.equals("logout")) {
			action = new LogoutAction();
		} else if (command.equals("join_form")) {
			action = new JoinFormAction();
		} else if (command.equals("join")) {
			action = new JoinAction();
		} else if (command.equals("manage_user")) {
			action = new ManageUserAction();
		} else if (command.equals("user_view")) {
			action = new UserViewAction();
		} else if (command.equals("update_user")) {
			action = new UpdateUserAction();
		} else if (command.equals("delete_user")) {
			action = new DeleteUserAction();
		} else if (command.equals("id_check")) {
			action = new IdCheckAction();

		// 상품-------------------------------------------
		}else if (command.equals("manage_product")) {
				action = new ManageProductAction();
		} else if (command.equals("product_search")) {
			action = new SearchAction();
		} else if (command.equals("product_registration_form")) {
			action = new ProductRegistrationFormAction();
		} else if (command.equals("product_registration")) {
			action = new ProductRegistrationAction();
		} else if (command.equals("product_view")) {
			action = new ProductViewAction();
		} else if (command.equals("product_update")) {
			action = new ProductUpdateAction();
		} else if (command.equals("product_delete")) {
			action = new ProductDeleteAction();

		// 운동-------------------------------------------

		} else if (command.equals("training")) {
			action = new TrainingAction();
		} else if (command.equals("exercise_recommend")) {
			action = new ExerciseRecommend();
			
			
			
			
		// 정환-------------------------------------------	
			
		}else if (command.equals("mypage")) {
			action = new MyPageAction();
		} else if (command.equals("schedule")) {
			action = new ScheduleAction();
		} else if (command.equals("training")) {
			action = new TrainingAction();
		} else if (command.equals("place")) {
			action = new PlaceAction();
		} else if (command.equals("shop")) {
			action = new ShopAction();
		} else if (command.equals("about")) {
			action = new AboutAction();
		} else if (command.equals("admin")) {
			action = new AdminAction();
		} else if (command.equals("place_select")) {
			action = new PlaceSelectAction();
		} else if (command.equals("dong_select")) {
			action = new DongSelectAction();
		} else if (command.equals("gym_select")) {
			action = new GymSelectAction();
		} else if (command.equals("user_spec")) {
			action = new UserSpecAction();
		} else if (command.equals("user_change")) {
			action = new UserChangeAction();
		} else if (command.equals("user_shop")) {
			action = new UserShopAction();
		} else if (command.equals("update_mypageuser")) {
			action = new UpdateMypageUser();
		} else if (command.equals("delete_mypageuser")) {
			action = new DeleteMypageUser();
		} else if (command.equals("insert_spec")) {
			action = new InsertSpecAction();
		}
		
		// 숫성씨-------------------------------------------		
		
		else if(command.equals("workout_list")) {
			action = new WorkoutListAction();
		}else if(command.equals("workout_write_form")) {
			action = new WorkoutWriteFormAction();
		}else if(command.equals("workout_write")) {
			action = new WorkoutWriteAction();
		}else if(command.equals("workout_view")) {
			action = new WorkoutViewAction();
		}else if(command.equals("mealplan_write_form")) {
			action = new MealplanWriteFormAction();
		}else if(command.equals("mealplan_write")) {
			action = new MealplanWriteAction();
		}else if(command.equals("mealplan_view")) {
			action = new MealplanViewAction();
		}else if(command.equals("workout_delete")) {
			action = new WorkoutDeleteAction();
		}else if(command.equals("workout_update")) {
			action = new WorkoutUpdateAction();
		}else if(command.equals("mealplan_delete")) {
			action = new MealplanDeleteAction();
		}
		
		
		
		// 명주-------------------------------------------
	    else if(command.equals("products")) {
			return new ProductListAction(command);
		}else if(command.equals("product")){
			return new ProductDetailAction(command);
		}else if(command.equals("mall_main")) {
			action = new MallMainAction();
		}
		
		// 연화-------------------------------------------
		
		else if (command.equals("cart_list")) {
			action = new CartListAction();
		} else if (command.equals("cart_insert")) {
			action = new CartInsertAction();
		} else if (command.equals("cart_delete")) {
			action = new CartDeleteAction();
		}else if(command.equals("cart_view")) {
			action=new CartViewAction();
		}else if (command.equals("cart_update")) {
			action =new CartUpdateAction();
		}else if (command.equals("cart_basket")) {
			action =new CartBasketAction();
		}else if(command.equals("cart_delete_all")) {
	         action=new CartDeleteAllAction();
	    }else if(command.equals("cart_pay")) {
	    	action=new CartPayAction();
	    }

		return action;
	}

}
