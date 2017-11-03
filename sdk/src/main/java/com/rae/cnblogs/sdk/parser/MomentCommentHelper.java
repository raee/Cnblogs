package com.rae.cnblogs.sdk.parser;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.rae.cnblogs.sdk.bean.MomentCommentBean;
import com.rae.cnblogs.sdk.utils.ApiUtils;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * 闪存评论解析
 * Created by ChenRui on 2017/11/2 0002 17:48.
 */
public class MomentCommentHelper {

    /**
     * 解析评论
     *
     * @param element 节点
     */
    @Nullable
    public List<MomentCommentBean> parse(Element element) {

        // 解析评论
        Elements commentLiElements = element.select(".feed_ing_comment_block li");

        // 闪存ID
        String ingId = ApiUtils.getNumber(element.select(".feed_ing_comment_block ul").attr("id"));

        if (commentLiElements.size() > 0) {
            List<MomentCommentBean> commentList = new ArrayList<>();
            for (Element commentLiElement : commentLiElements) {
                MomentCommentBean commentBean = new MomentCommentBean();

                // 没有更多的评论
                if (commentLiElement.select("a").text().contains("浏览更多")) {
                    commentBean.setContent(commentLiElement.text());
                    commentBean.setId("more");
                    commentList.add(commentBean);
                    continue;
                }

                // 评论ID
                String commentId = ApiUtils.getNumber(commentLiElement.attr("id"));
                String userAlias = ApiUtils.getUserAlias(commentLiElement.select(".ing_reply").attr("onclick"));
                String content = commentLiElement.select(".ing_comment").text();
                if (TextUtils.isEmpty(commentId)) continue;

                // @用户处理
                Elements atUserElement = commentLiElement.select(".ing_comment a");
                if (atUserElement.text().contains("@")) {
                    commentBean.setAtAuthorName(atUserElement.text());
                    commentBean.setAtUserAlias(ApiUtils.getBlogApp(atUserElement.attr("href")));
//                    content = content.replace(commentBean.getAtAuthorName(), "");
//                    content = content.trim().startsWith("：") ? content.substring(1) : content;
                }

                commentBean.setId(commentId);
                commentBean.setIngId(ingId);
                commentBean.setUserAlias(userAlias);
                commentBean.setContent(content);
                commentBean.setAuthorName(commentLiElement.select("#comment_author_" + commentId).text());
                commentBean.setBlogApp(ApiUtils.getBlogApp(commentLiElement.select("#comment_author_" + commentId).attr("href")));
                commentBean.setPostTime(commentLiElement.select(".ing_comment_time").text().replace("回应于", ""));
                commentList.add(commentBean);
            }

            return commentList;
        }

        return null;
    }

}
