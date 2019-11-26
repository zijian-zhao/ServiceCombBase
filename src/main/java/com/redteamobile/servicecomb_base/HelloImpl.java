/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.redteamobile.servicecomb_base;

import com.redteamobile.servicecomb_base.dao.TestDao;
import com.redteamobile.servicecomb_base.dao.entity.TestBean;
import com.redteamobile.servicecomb_base.dao.helper.RedisOperImpl;
import io.swagger.annotations.ApiOperation;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestSchema(schemaId = "hello")
@RequestMapping(path = "/")
public class HelloImpl {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TestDao testDao;

    @Autowired
    private RedisOperImpl redisOper;

    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello World!";
    }

    @ApiOperation("查询用户")
    @GetMapping(path = "/users/{name}")
    public String getUser(@PathVariable("name") String name) {
        logger.error("enter getuser,username:{}", name);
        TestBean bean = testDao.findByName(name);
        return String.format("user :%s, id:%s", bean.getName(), bean.getId());
    }

    @GetMapping(path = "/redis/keys/{key}")
    public String getKeyFromRedis(@PathVariable("key") String key) {
        logger.error("enter getKeyFromRedis,key:{}", key);
        String value = String.valueOf(redisOper.get(key));
        return String.format("getKeyFromRedis key :%s, value:%s", key, value);
    }
}