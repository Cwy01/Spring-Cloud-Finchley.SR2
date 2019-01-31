package com.boot.vue.service;

import com.boot.vue.pojo.Status;
import com.boot.vue.pojo.TableStatus;

public interface VueService {

	Status topics();
	Status topic();
	Status pieDatas();
	TableStatus tableDatas();
}