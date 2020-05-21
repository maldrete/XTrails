import { User } from '../user/user';


export class Comment {
  id: number;
  actualComment: string;
  user: User;
  trail: trail;
  datePosted: Date;

  constructor(
    id?: number,
    actualComment?: string,
    user?: User,
    trail?: trail,
    datePosted?: Date
  ) {
    this.id = id;
    this.actualComment = actualComment;
    this.user = user;
    this.trail = trail;
    this.datePosted = datePosted;
  }
}
