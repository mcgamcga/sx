package com.c.c.dao;

import com.c.c.bean.LotteryHistory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LotteryHistoryDao {

	/**
	 * 插入
	 * @param lotteryHistory
	 * @return
	 */
	public int insert(LotteryHistory lotteryHistory);

	/**
	 * 查询最新一期
	 * @return
	 */
	public LotteryHistory selectMax();

	/**
	 * 查询全部
	 * @return
	 */
	public List<LotteryHistory> selectAll();

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public LotteryHistory selectById(String id);

	/**
	 * 从指定数字中查询下一期出现过的id
	 * @return
	 */
	public List<Integer> selectRedListOfAppointDown(Map map);

	/**
	 * 根据id in
	 * @return
	 */
	public List<LotteryHistory> selectAllDownFromId(List<Integer> list);

	/**
	 * 查询是否出现过
	 * @return
	 */
	public List<LotteryHistory> selectByRedAll(Map map);
}
