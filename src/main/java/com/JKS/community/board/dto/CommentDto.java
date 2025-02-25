package com.JKS.community.board.dto;

import com.JKS.community.board.domain.Comment;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.format.DateTimeFormatter;

@Getter @Setter
@ToString
public class CommentDto {
    private Long id;
    private Long postId;
    private String content;
    private int likeCount;
    private int dislikeCount;
    private Long parentId;
    private int level;
    private boolean enabled;
    private String createdDate;
    private String modifiedDate;

    private Long memberId;
    private String memberName;
    private Long parentMemberId;
    private String parentMemberName;
    private int childrenSize;

    public CommentDto(Comment comment) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");

        this.id = comment.getId();
        this.postId = comment.getPost().getId();
        this.content = comment.getContent();
        this.likeCount = comment.getLikeCount();
        this.dislikeCount = comment.getDislikeCount();
        this.parentId = (comment.getParent() != null) ? comment.getParent().getId() : null;
        this.level = comment.getLevel();
        this.enabled = comment.isEnabled();
        this.createdDate = (comment.getCreatedDate() != null) ? comment.getCreatedDate().format(formatter) : null;
        this.modifiedDate = (comment.getLastModifiedDate() != null) ? comment.getLastModifiedDate().format(formatter) : null;

        this.memberId = comment.getMember().getId();
        this.memberName = comment.getMember().getName();
        this.childrenSize = comment.getChildren().size();

        if (comment.getParent() != null) {
            this.parentMemberId = comment.getParent().getMember().getId();
            this.parentMemberName = comment.getParent().getMember().getName();
        }
    }
}
